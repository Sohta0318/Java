public class Continue {
    public static void main(String[] args) {
        int number = 0;
        while(number < 50){
            number += 5;
            if(number % 25 == 0){
                continue;
            }
            System.out.println(number + "_");
        }
    }
}
