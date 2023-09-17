package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Card> deck = Card.getStandardDeck();
//        Card.printDeck(deck);
//        System.out.println(deck.subList(0,3));
//        System.out.println(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        Card.printDeck(cards);
        System.out.println("Cards size = " + cards.size());


Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        //        cards.addAll(cardArray);
//        cards.addAll(Arrays.asList(cardArray));
        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards,"Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List copy of kings", 1);


    }
}
