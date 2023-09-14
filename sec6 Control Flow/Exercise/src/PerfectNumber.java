public class PerfectNumber {
    public static void main(String[] args) {
System.out.println(isPerfectNumber(5));
    }

    public static boolean isPerfectNumber(int number){
        if(number < 1){
            return false;
        }
        int total = 0;
        int divider = 1;
        while(divider < number ){
            if(number % divider == 0){
                total += divider;
            }
            divider++;
        }
        return total == number;
    }
}
