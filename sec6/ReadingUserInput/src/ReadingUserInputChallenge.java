import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
try {
    getUserInput();
}catch(NumberFormatException e){
    System.out.println("Invalid Value");
}
    }

    public static void getUserInput(){
        int count = 1;
        double total = 0;
        Scanner scanner = new Scanner(System.in);
        while(count <= 5){
            System.out.println("Enter number #" + count + ":");
//            int inputNumber = Integer.parseInt(scanner.nextLine());
            double inputNumber = Double.parseDouble(scanner.nextLine());
            total += inputNumber;
            count++;
        }
        System.out.println("Total sum is " + total);
    }

}
