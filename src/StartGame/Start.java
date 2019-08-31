package StartGame;

import CardDeck.Card;
import Players.User;
import Table.Table;
import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;

public class Start {
    User player;
    User dealer;
    List<Card> deck;
    Table table;
    List<Card> playerCard;
    List<Card> dealerCard;
    boolean standFlag;
    Status gameStatus;

    /*    Player,dealer,cards and table are initialized to get the game started.     */
    Start(User player, User dealer, List<Card> deck, Table table){
        this.player=player;
        this.dealer=dealer;
        this.deck=deck;
        this.table=table;
        standFlag=false;
    }

    /*    This function is to verify if players bet is greater than minBet of the table     */
    public boolean checkBetValidity(){
        if(player.getBet() >= table.getMinBet()){
            return true;
        }
        return false;
    }

    /*    Deal function is responsible to distribute 2 cards to player and dealer each     */
    public void deal(){
        playerCard=new ArrayList<>();
        dealerCard=new ArrayList<>();
        playerCard.add(deck.remove(0));
        dealerCard.add(deck.remove(0));
        playerCard.add(deck.remove(0));
        dealerCard.add(deck.remove(0));
    }

    /*    This function checks if the player has obtained a blackjack (21)     */
    public boolean checkBlackJack(){
        if(playerHandValue() == 21){
            gameStatus=Status.Players_wins;
            return true;
        }
        return false;
    }

    /*    This function returns the sum of players hand value     */
    public int playerHandValue(){
        int sum=0;
        for (Card temp: playerCard){
            sum+=temp.getValue();
        }
        return sum;
    }

    /*    This function returns the sum of dealer hand value      */
    public int dealerHandValue(){
        if(standFlag == true){
            int sum=0;
            for(Card temp: dealerCard){
                sum+=temp.getValue();
            }
            return sum;
        }
        return dealerCard.get(0).getValue();
    }

    /*    The hit function is responsible to distribute a card to the player     */
    public void hit(){
        playerCard.add(deck.remove(0));
        if(playerHandValue() > 21){
            gameStatus=Status.Dealer_wins;
        }
    }

    /*    The stand function distribute cards till he wins or loses     */
    public void stand(){
        standFlag=true;
        while(true){
            if(checkDealerHandValue()){
                //Compare Logic
                if(dealerHandValue() > playerHandValue() && dealerHandValue() <= 21){
                    gameStatus= Status.Dealer_wins;
                    break;
                }
                dealerCard.add(deck.remove(0));
            }
            else{
                //dealer burst
                gameStatus=Status.Players_wins;
                break;
            }

        }
    }

    /*    The purpose of this is to check if handValue of player is exceeded and player is lost     */
    public boolean checkPlayerHandValue(){
        if(playerHandValue() > 21){
            //player burst
            gameStatus=Status.Dealer_wins;
            return false;
        }
        return true;
    }

    /*    The purpose of this function is to check if the handValue of dealer is exceeded and player wins     */
    public boolean checkDealerHandValue(){
        if(dealerHandValue() > 21){
            gameStatus=Status.Players_wins;
            return false;
        }
        return true;
    }

    public Status getGameStatus(){
        return gameStatus;
    }


}
