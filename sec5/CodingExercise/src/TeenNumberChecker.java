public class TeenNumberChecker {
    public static void main(String[] args) {

    }
    public static boolean hasTeen(int n1, int n2, int n3) {
        return isTeen(n1) || isTeen(n2) || isTeen(n3);
    }

    public static boolean isTeen(int n){
        return n >= 13 && n <= 19;
    }
}
