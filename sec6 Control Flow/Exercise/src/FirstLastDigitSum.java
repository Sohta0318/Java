public class FirstLastDigitSum {
    public static void main(String[] args) {
System.out.println(sumFirstAndLastDigit(5));
    }

    public static int sumFirstAndLastDigit (int number){
        if(number < 0){
            return -1;
        } else if (number < 10) {
            return number * 2;
        }
        int total = number % 10;
        do{
number /= 10;
if(number < 10){
    int lastIndex = number % 10;
    total += lastIndex;
    break;
}
        }while(true);
        return total;
    }
}
