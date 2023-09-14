public class SumOddRange {
    public static void main(String[] args) {
System.out.println(isOdd(-2));
        System.out.println(isOdd(2));
        System.out.println(isOdd(5));
    }

    public static boolean isOdd(int number){
//        if(number < 0){
//            return false;
//        } else if (number % 2 == 0) {
//            return false;
//        }
//        return true;

        return number < 0 ? false : !(number % 2 == 0);
    }

    public static int sumOdd(int start, int end){
        if(start <= 0 || end <= 0 || end < start){
            return -1;
        }
        int sum = 0;
for(int i = start; i <= end; i++){
if(isOdd(i)){
    sum += i;
}
}
return sum;
    }
}
