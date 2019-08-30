package Card;

import java.util.ArrayList;
import java.util.List;

public class Card {

    Suit suitName;
    int value;


    Card(){

    }

    Card(Suit suitName, int value){
        this.suitName=suitName;
        this.value=value;
    }

    public Suit getSuitName() {
        return suitName;
    }

    public int getValue() {
        return value;
    }

    public void getDeck(){
        List<Integer> val= new ArrayList<>();{1,2,3,4,5,6,7,8,9,10,11};
    }

    @Override
    public String toString() {
        return "Card{" +
                "suitName=" + suitName +
                ", value=" + value +
                '}';
    }

}
