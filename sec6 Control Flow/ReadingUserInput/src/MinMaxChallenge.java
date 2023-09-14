import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        int loopCount = 0;
        while (true) {
            try {
                System.out.println("Enter a number");
                int date = Integer.parseInt(scanner.nextLine());
               if (loopCount == 0 || max < date) {
                    max = date;
                }
               if (loopCount == 0 || min > date) {
                    min = date;
                }
                loopCount ++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Value");
                break;
            }
        }
        if(loopCount > 0){
            System.out.println("min = " + min + " max = "+ max);
        }else{
            System.out.println("Invalid Value");
        }
    }
}
