public class LargestPrime {
    public static void main(String[] args) {
System.out.println(getLargestPrime(16));
    }

    public static int getLargestPrime(int number){
        if(number < 2){
            return -1;
        }
        int count = 2;
        while(count < number){
            int prime = number % count;
            if(prime == 0 ){
                number /= count;
                count --;
            }
            count++;
        }
        return number;
    }
}
