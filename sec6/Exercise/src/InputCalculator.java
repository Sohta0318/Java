import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while(true){
            try{
int inputNum = Integer.parseInt(scanner.nextLine());
sum += inputNum;
count ++;
            }catch (NumberFormatException e){
                break;
            }
        }
        long avg = Math.round((sum / (double)(count)));
        System.out.println("SUM = " + sum + " AVG = " + avg);
    }
}
