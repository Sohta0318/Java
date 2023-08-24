public class LastDigitChecker {
    public static void main(String[] args) {
System.out.println(hasSameLastDigit(11,32,21));
    }

    public static boolean hasSameLastDigit(int num1, int num2,int num3){
if(!isValid(num1) || !isValid(num2) || !isValid(num3)){
    return false;
}
    int a = num1 % 10;
    int b = num2 % 10;
    int c = num3 % 10;
    if((a == b) || (a == c) || (b == c)){
        return true;
    }
return false;
    }

    public static boolean isValid(int number){
        return number >= 10 && number <= 1000;
    }
}
