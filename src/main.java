import java.util.Scanner;

public class main {
    public static void main(String[] args){
        User user = new User("User");
        User bank = new User("Bank", true);
        System.out.println("You have " + user.getCoins() + " enjoy!");
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        do{

            Hand hand = new Hand(user, bank);
            if (hand.isPlayerWins()){
                user.updateCoins(user.getCurrentBet()*2);
            }else if (hand.isTie()){
                user.updateCoins(user.getCurrentBet());
            }
            System.out.println("Current amount : " + user.getCoins());
            if (user.getCoins() != 0){

                System.out.println("Do you want to replay ?");
                choice = scan.nextInt();
            }
            bank.resetHand();
            user.resetHand();
        }while (choice != 0 && user.getCoins() != 0);
        if (user.getCoins() == 0){
            System.out.println("Game over");
        }
        System.out.println("Game finished. See you soon !");

    }
}
