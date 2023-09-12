package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Banking {
    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }
}

class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        for(var branch : branches){
            if(branch.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return branches.add(new Branch(name));
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            for(var customer : branch.getCustomers()){
                if(customer.getName().equalsIgnoreCase(customerName)){
                    return false;
                }
            }
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, initialTransaction);
        }
        return false;
    }

    private Branch findBranch(String name) {
        for (var branch : branches) {
            if (branch.getName().equalsIgnoreCase(name)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String name, boolean printTransactions){
        for (Branch branch: branches) {
            if (branch.getName().equals(name)){
                if (printTransactions){
                    System.out.println("Customer details for branch " + branch.getName());
                    for (Customer customer:branch.getCustomers()) {
                        System.out.println("Customer: " + customer.getName() + "[" + (branch.getCustomers().indexOf(customer)+1) + "]");
                        System.out.println("Transactions");
                        for (Double transaction:customer.getTransactions()) {
                            System.out.println("[" + (customer.getTransactions().indexOf(transaction)+1) + "]  Amount " + transaction);
                        }
                    }
                    return true;
                }
                System.out.println("Customer details for branch " + branch.getName());
                for (Customer customer:branch.getCustomers()) {
                    System.out.println("Customer: " + customer.getName() + "[" + (branch.getCustomers().indexOf(customer)+1) + "]");
                }
                return true;
            }
        }
        return false;
    }
}

class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction) {
        for(var customer : customers){
            if(customer.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return customers.add(new Customer(name, initialTransaction));
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name) {
        for (var customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}

class Customer {
    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>(List.of(initialTransaction));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        String text = "Customer: " + name + "\n" + "Transactions\n";
        for (int i = 0; i < transactions.size(); i++) {
            text += "[" + (i + 1) + "] Amount " + transactions.get(i) + "\n";
        }
        return text;
    }
}
