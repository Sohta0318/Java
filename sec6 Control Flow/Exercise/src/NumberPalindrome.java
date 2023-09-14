public class NumberPalindrome {
    public static void main(String[] args) {
System.out.println(isPalindrome(-1221));
    }

    public static boolean isPalindrome(int number){
        int reverse = 0;
        int positive = Math.abs(number);
        int last = Math.abs(number);
        while(positive > 0){
//            if(positive == 0){
//                break;
//            }
int lastDigit = positive % 10;
reverse = (reverse * 10) + lastDigit;
positive /= 10;
        }

        return reverse == last;
    }
}
