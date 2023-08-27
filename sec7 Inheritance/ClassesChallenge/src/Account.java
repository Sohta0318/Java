public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double money){
        balance += money;
        System.out.println("Deposit of $" + money + " made. New balance is $" + balance);
    }

    public void withdraw(double money){
        if(money > balance) {
            System.out.println("Insufficient Funds! You only have $" + balance + " in your bank account");
        }else {
            balance -= money;
            System.out.println("Withdraw of $" + money + " made. New balance is $" + balance);
        }
    }
}
