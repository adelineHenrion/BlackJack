import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private int Coins;
    private DeckOfCards UserDeck;
    private int currentBet;
    private boolean bank = false;
    private int handValue;

    User(String username, boolean... bank){
        this.username = username;
        this.Coins = 1000;
        this.bank = bank.length > 0 && bank[0];
        if(this.bank){
            this.UserDeck = new DeckOfCards(new ArrayList<Card>(), State.Face_Side);
        }else{
            this.UserDeck = new DeckOfCards(new ArrayList<Card>(), State.Unfolded);
        }
    }

    public void SetCurrentBet(){
        Scanner scan = new Scanner(System.in);
        System.out.println( username + ", how many do you want to bet ?");
        this.currentBet = scan.nextInt();
        if (this.currentBet > this.Coins){
            do{
                System.out.println("Please try again");
                this.currentBet = scan.nextInt();
            }while (this.currentBet > this.Coins);
        }
        this.Coins -= this.currentBet;
    }

    public void AddCards(ArrayList<Card> cards){
        UserDeck.AddCards(cards);
    }

    public DeckOfCards getUserDeck() {
        return UserDeck;
    }

    public String getUsername() {
        return username;
    }

    public int getHandValue() {
        this.handValue = UserDeck.countBlack();
        return handValue;
    }

    public void newCard(Card card) {
        this.UserDeck.AddCard(card);
        this.handValue = UserDeck.countBlack();
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void updateCoins(int coins){
        Coins += coins;


    }
    public void resetHand(){
        currentBet = 0;
        handValue = 0;
        if (this.bank){

            this.UserDeck = new DeckOfCards(new ArrayList<Card>(), State.Face_Side);
        }else {

            this.UserDeck = new DeckOfCards(new ArrayList<Card>());
        }
    }

    public int getCoins() {
        return Coins;
    }
}
