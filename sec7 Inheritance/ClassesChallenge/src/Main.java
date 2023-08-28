public class Main {
    public static void main(String[] args) {
        //Account account = new Account("1234", 1000.0, "Bob Brown", "myemail@bob.com", "(087) 123-4567");

        Account account = new Account();

        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
//        account.setAccountNumber("12345");
//        account.setCustomerName("Bob Brown");
//        account.setEmail("myemail@bob.com");
//        account.setPhoneNumber("(087) 123-4567");
//        account.setBalance(2000);
        account.deposit(3000);
        account.withdraw(4000);
        System.out.println("Balance = " + account.getBalance());

        Account timsAccount = new Account("Tim", "tim@email.com", "12345");
        System.out.println("AccountNo: " + timsAccount.getAccountNumber() + "; name:" + timsAccount.getCustomerName());


        Customer customer = new Customer("Tim", 1000, "tim@mail.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmail());

        Customer secondCustomer = new Customer();
        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getCreditLimit());
        System.out.println(secondCustomer.getEmail());

        Customer thirdCustomer = new Customer("Test", "test@mail.com");
        System.out.println(thirdCustomer.getName());
        System.out.println(thirdCustomer.getCreditLimit());
        System.out.println(thirdCustomer.getEmail());


    }
}
