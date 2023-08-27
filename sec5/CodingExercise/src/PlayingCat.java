public class PlayingCat {
    public static void main(String[] args) {
        boolean a = isCatPlaying(true, 45);
        boolean b = isCatPlaying(false, 45);
        System.out.println(a);
        System.out.println(b);
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        if(!summer && temperature>= 25 && temperature <=35){
            return true;
        } else if (summer && temperature>= 25 && temperature <=45 ) {
            return true;
        }
        return false;
    }
}
