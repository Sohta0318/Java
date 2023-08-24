public class SharedDigit {
    public static void main(String[] args) {
System.out.println(hasSharedDigit(12, 13));
    }

    public static boolean hasSharedDigit(int num1, int num2){
        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99){
            System.out.println("Invalid");
            return false;
        }
        int fake = num2;
        while(num1 > 0){
            int a = num1 % 10;
            while(num2 > 0){
                int b = num2 % 10;
                if(a == b){
                    return true;
                }
                num2 /= 10;
            }
            num2 = fake;
            num1 /= 10;
        }
        return false;
    }
}
