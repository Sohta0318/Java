public class EvenDigitSum {
    public static void main(String[] args) {
System.out.println(getEvenDigitSum(252));
    }
    public static int getEvenDigitSum(int number){
        if(number < 0){
            return -1;
        }
        int total = 0;
        while (number > 0) {
            int index = number % 10;
            if(index %2 == 0){
                total+= index;
            }
number /= 10;
        }
        return total;
    }
}
