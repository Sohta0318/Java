package dev.lpa;

public class Main {
    public static void main(String[] args) {

    }
}
class Card{
    private Suit suit;
    private String face;
    private int rank;

    public Card(Suit suit, String face, int rank) {
        this.suit = suit;
        this.face = face;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", face='" + face + '\'' +
                ", rank=" + rank +
                '}';
    }
    public static Card getNumericCard(Suit suit, int number){
        return new Card();
    }
    public static Card getFaceCars(Suit suit, String face){

    }
}
