package Table;

import CardDeck.Card;
import CardDeck.Suit;

import java.util.ArrayList;
import java.util.List;

public class Check {
    static void printCards(List<Card> deck){
        for(Card i:deck){
            System.out.println(i.toString());
        }
    }
    public static void main(String[] args) {
        List<Card> deck= new ArrayList<>();
        deck.add(new Card(Suit.Club, 7));
        deck.add(new Card(Suit.Club, 8));
        deck.add(new Card(Suit.Club, 9));
        deck.add(new Card(Suit.Club, 10));
        deck.add(new Card(Suit.Club, 11));
        printCards(deck);
        Card c1=deck.remove(0);
        System.out.println(c1.toString());
        System.out.println();
        printCards(deck);
    }
}
