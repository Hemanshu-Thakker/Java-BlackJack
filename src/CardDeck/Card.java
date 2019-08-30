package CardDeck;

public class Card {

    Suit suitName;
    Integer value;


    Card(){

    }

    Card(Suit suitName, Integer value){
        this.suitName=suitName;
        this.value=value;
    }

    public Suit getSuitName() {
        return suitName;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suitName=" + suitName +
                ", value=" + value +
                '}';
    }

}
