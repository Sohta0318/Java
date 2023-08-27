public class DigitSumChallenge {
    public static void main(String[] args) {
System.out.println(sumDigit(125));
    }

    public static int sumDigit(int number){
        if(number < 0) {
            return -1;
        }
        int total = 0;
        while(true){
           if(number == 0){
               break;
           }
            total += number % 10;
            number = number / 10;
        }
        return total;
    }
}
