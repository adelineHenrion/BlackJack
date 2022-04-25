import java.util.Scanner;

public class Hand {
    private boolean playerWins= false;
    private boolean tie= false;

    Hand(User user, User bank){
        user.SetCurrentBet();
        //create a deck with all the cards
        DeckOfCards mainDeck = new DeckOfCards();

        //create the banck hand
        bank.AddCards(mainDeck.pickRandom(2));
        // create the player hand
        user.AddCards(mainDeck.pickRandom(2));

        // display the hands
        display(user, bank);

        //player then bank turn
        playerTurn(user, mainDeck);
        if(user.getHandValue() <=21){
            banckTurn(bank, mainDeck);
        }


        results(user, bank);

    }
    static void display(User player, User... bank){
        if(bank.length > 0){
            System.out.println(bank[0].getUsername() + " deck :");
            System.out.println(bank[0].getUserDeck());
        }
        System.out.println(player.getUsername() + " deck :");
        System.out.println(player.getUserDeck());
        System.out.println(player.getUsername() + " value :");
        System.out.println(player.getHandValue());
    }

    static void playerTurn(User player, DeckOfCards deck){
        Scanner scan = new Scanner(System.in);
        int choice=0;
        loop :while(player.getHandValue() <= 21){
            System.out.println("What do you whant to do ? \n" +
                    "1- Hit (take another card) \n" +
                    "2- Stand");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    player.newCard(deck.pickRandom());
                    break;
                case 2:
                    break loop;
            }
            display(player);
        }

    }

    static void banckTurn(User banck, DeckOfCards deck){
        banck.getUserDeck().ChangeState(State.Unfolded);
        display(banck);
        while (banck.getHandValue() < 17){
            banck.newCard(deck.pickRandom());
        }
        display(banck);
    }

    void results(User user, User bank){
        if(user.getHandValue() > 21){
            System.out.println("Bank win !");
        }else if (bank.getHandValue() > 21 || bank.getHandValue() < user.getHandValue()){
            System.out.println("Player win !");
            this.playerWins = true;
        }else if(user.getHandValue() == bank.getHandValue()){
            System.out.println("Tie");
            this.tie = true;
        }else {
            System.out.println("Tie");
            this.tie = true;
        }
    }

    public boolean isPlayerWins() {
        return playerWins;
    }

    public boolean isTie() {
        return tie;
    }
}
