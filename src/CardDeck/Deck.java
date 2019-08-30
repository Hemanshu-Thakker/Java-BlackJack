package CardDeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> deck;
    List<Integer> values;

    Deck(){
        deck=new ArrayList<>();
        values= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,10,10,11));
    }

    public void createDeck(){
        for(Suit s: Suit.values()){
            for(Integer i: values ){
                deck.add(new Card(s,i));
            }
        }
    }

    public List<Card> shuffleDeck(){
        Collections.shuffle(deck);
        return deck;
    }
}
