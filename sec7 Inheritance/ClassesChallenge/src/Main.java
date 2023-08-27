public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber("12345");
        account.setCustomerName("Bob Brown");
        account.setEmail("myemail@bob.com");
        account.setPhoneNumber("(087) 123-4567");
        account.setBalance(2000);
        account.deposit(3000);
        account.withdraw(4000);
        System.out.println("Balance = " + account.getBalance());
    }
}
