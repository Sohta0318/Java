public class Challenge {
    public static void main(String[] args) {
double value = 20.00d;
double value2 = 80.00d;
double total = (value + value2) * 100.00d;
double reminder = total % 40.00d;
boolean isZero = reminder == 0.00d;
System.out.println(isZero);

if(!isZero){
    System.out.println("got some reminder");
}

    }
}
