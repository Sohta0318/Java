public class GreatestCommonDivisor {
    public static void main(String[] args) {
System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(25, 15));
    }

    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10){
            return -1;
        }
        int divider = 1;
        int maximum = 1;
        while(divider <= first && divider <= second){
            if(first % divider == 0 && second % divider == 0 && divider > maximum){
                maximum = divider;
            }
            divider++;
        }
        return maximum;
    }
}
