public class Main {
    public static void main(String[] args) {
        double kilometers = (100 * 1.609344);

        int highScore = 50;
        if(highScore > 25){
            highScore = 1000 + highScore; // add bonus point
        }
        int health = 100; // This is expression
        if(health < 25 && highScore > 1000) // This is expression
        {
            highScore = highScore - 1000; // this is expression
        }

        // 6 expressions for total

        int myValuable = 50;
        myValuable++;
        myValuable--;

        System.out.println("This is a test");

        System.out.println("This" +
                " another" +
                " test");

        int anotherValuable = 50; anotherValuable++; anotherValuable--; System.out.println("This is result = " + anotherValuable);

        if(anotherValuable == 0){
            System.out.println("It's now zero");
        }
    }
}
