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

    /**
     * In this testcase the player wins the game by receiving a perfect BlackJack(21) in the beginning.
     */
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

    /**
     * In this testcase the player wins the game by receiving a hand value of 20 and bursting the dealer
     */
    @org.junit.Test
    public void test_PlayerWin(){
        deck.add(new Card(Suit.Club ,2));   //player
        deck.add(new Card(Suit.Diamond, 10));   //dealer
        deck.add(new Card(Suit.Spade, 11));  //player
        deck.add(new Card(Suit.Heart, 8));   //dealer
        deck.add(new Card(Suit.Diamond, 7));    //player
        deck.add(new Card(Suit.Heart, 9));  //dealer

        Start start= new Start(player,dealer,deck,table);
        Assert.assertTrue(start.checkBetValidity());
        start.deal();
        Assert.assertFalse(start.checkBlackJack());
        start.hit();
        Assert.assertEquals(20,start.playerHandValue());
        start.stand();
        Assert.assertEquals(Status.Players_wins,start.getGameStatus());
    }

    /**
     * In this testcase the dealer wins by scoring the hand value greater than players hand value and lesser than 21
     */
    @org.junit.Test
    public void test_dealerWin(){

        deck.add(new Card(Suit.Club ,2));   //player
        deck.add(new Card(Suit.Diamond, 10));   //dealer
        deck.add(new Card(Suit.Spade, 5));  //player
        deck.add(new Card(Suit.Heart, 8));   //dealer
        deck.add(new Card(Suit.Diamond, 7));    //player
        deck.add(new Card(Suit.Heart, 9));  //dealer

        Start start= new Start(player,dealer,deck,table);
        Assert.assertTrue(start.checkBetValidity());
        start.deal();
        Assert.assertFalse(start.checkBlackJack());
        start.hit();
        Assert.assertEquals(14,start.playerHandValue());
        start.stand();
        Assert.assertEquals(Status.Dealer_wins,start.getGameStatus());
    }

    /**
     * In this testcase the dealer wins since the player burst on hit
     */
    @org.junit.Test
    public void test_dealerWinPlayerBurst(){

        deck.add(new Card(Suit.Club ,9));   //player
        deck.add(new Card(Suit.Diamond, 10));   //dealer
        deck.add(new Card(Suit.Spade, 5));  //player
        deck.add(new Card(Suit.Heart, 8));   //dealer
        deck.add(new Card(Suit.Diamond, 10));    //player
        deck.add(new Card(Suit.Heart, 9));  //dealer

        Start start= new Start(player,dealer,deck,table);
        Assert.assertTrue(start.checkBetValidity());
        start.deal();
        Assert.assertFalse(start.checkBlackJack());
        start.hit();
        Assert.assertEquals(24,start.playerHandValue());
        Assert.assertEquals(Status.Dealer_wins,start.getGameStatus());
    }
}