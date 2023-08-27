public class Main {
    public static void main(String[] args) {
//int newScore = calculateScore("Tim", 500);
//System.out.println("New score is "+ newScore);
//
//calculateScore(75);
//calculateScore();

        System.out.println("New score is " + calculateScore("Tim", 500));
        System.out.println("New score is " + calculateScore(10));
        double test = convertToCentimeters(68);
        System.out.println(test);
        double test2 = convertToCentimeters(5,8);
        System.out.println(test2);
    }
    public static int calculateScore(String name, int score){
        System.out.println("Player "+ name+ " score "+ score + " points");
        return score * 1000;
    }

    public static int calculateScore( int score){
        return calculateScore("Anonymous", score);
    }

    public static int calculateScore(){
        System.out.println("No player name, no score point");
        return 0;
    }

//    public static void calculateScore(){
//        System.out.println("No player name, no score point");
//    }

    public static double convertToCentimeters(int inc){
        return (double)inc * 2.54;
    }
    public static double convertToCentimeters(int ft, int inc){
        int inches = (ft * 12) + inc;
        return convertToCentimeters(inches);
    }
}
