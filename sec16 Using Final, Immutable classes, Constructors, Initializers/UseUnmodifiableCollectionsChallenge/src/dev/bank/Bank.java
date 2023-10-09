package dev.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final int rotingNumber;
    private long transactionId = 1;
    private final Map<String, BankCustomer> customers;

    public Bank(int rotingNumber) {
        this.rotingNumber = rotingNumber;
        customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id){
        BankCustomer customer = customers.get(id);
        return customer;
    }
    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit){
        BankCustomer customer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(customer.getCustomerId(), customer);
    }
    public boolean doTransaction(String id, BankAccount.AccountType type, double amount){
        BankCustomer customer = getCustomer(id);
        if(customer != null){
            BankAccount account = customer.getAccount(type);
            if(account != null){
                if(account.getBalance() < 0){
                    System.out.println("Insufficient funds");
                }else {
                    account.commitTransaction(rotingNumber, transactionId++, id, amount);
                    return true;
                }
            }
        }else {
            System.out.println("Invalid customer id");
        }
        return false;

    }
}
