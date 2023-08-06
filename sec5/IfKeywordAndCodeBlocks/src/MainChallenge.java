public class MainChallenge {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;

        int highScore = calculateScore(true, 800, levelCompleted, bonus);
        System.out.println("The high score is " + highScore);

         score = 10000;
         levelCompleted = 8;
         bonus = 200;

System.out.println("The next high score is "+ calculateScore(gameOver, score, levelCompleted, bonus));

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){

        int finalScore = score;

        if(gameOver){
            finalScore += (levelCompleted * bonus);
//            System.out.println("Your final score was " + finalScore);
        }

        return finalScore;
    }
}
