package StartGame;

import CardDeck.Card;
import CardDeck.Deck;
import CardDeck.Suit;
import Players.User;
import Players.UserType;
import Table.Table;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StartTest {

    Start start;
    User player;
    User dealer;
    Table table;
    List<Card> deck;

    @org.junit.Before
    public void setUp() throws Exception {
        player=new User(20,500, UserType.player);
        dealer=new User(0,0,UserType.dealer);
        table=new Table(20);
        deck= new ArrayList<>();
    }

    @org.junit.Test
    public void test_PlayerWinOfBlackJack(){
        deck.add(new Card(Suit.Club ,10));   //player
        deck.add(new Card(Suit.Diamond, 10));   //dealer
        deck.add(new Card(Suit.Spade, 11));  //player
        deck.add(new Card(Suit.Heart, 8));   //dealer
        deck.add(new Card(Suit.Diamond, 8));    //player

        Start start=new Start(player,dealer,deck,table);
        Assert.assertTrue(start.checkBetValidity());
        start.deal();
        Assert.assertTrue(start.checkBlackJack());
        Assert.assertEquals(Status.Players_wins,start.getGameStatus());
    }


//    @org.junit.Test
//    public void test_checkBetValidity() {
//    }
//
//    @org.junit.Test
//    public void checkBlackJack() {
//    }
//
//    @org.junit.Test
//    public void playerHandValue() {
//    }
//
//    @org.junit.Test
//    public void dealerHandValue() {
//    }
//
//    @org.junit.Test
//    public void checkPlayerHandValue() {
//    }
//
//    @org.junit.Test
//    public void checkDealerHandValue() {
//    }
}