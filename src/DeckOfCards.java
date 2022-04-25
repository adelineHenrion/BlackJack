import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<Card> deck = new ArrayList<>();
    private State state;
    private boolean Ace = false;

    public DeckOfCards(){
        for(Rank rank: Rank.values()){
            deck.add(new Card(rank, Suit.Spades));
            deck.add(new Card(rank, Suit.Hearts));
            deck.add(new Card(rank, Suit.Diamonds));
            deck.add(new Card(rank, Suit.Clubs));
        }
        state = State.Underside;
    }

    public DeckOfCards(DeckOfCards existingDeck){
        deck = existingDeck.deck;
        state = existingDeck.state;
    }

    public DeckOfCards (Card card, State state){
        deck.add(card);
        this.state = state;
    }

    public DeckOfCards (String card){
        String[] splitted = card.split(" of ");
        System.out.println(Rank.valueOf(splitted[0]));
        System.out.println(Suit.valueOf(splitted[1]));
        deck.add(new Card(Rank.valueOf(splitted[0]), Suit.valueOf(splitted[1])));
    }

    public DeckOfCards (ArrayList<Card> cards, State... state){
        if (cards.size() > 0){
            deck = cards;
        }
        this.state = state.length > 0 ? state[0] : State.Unfolded;
    }

    public String toString() {
        StringBuilder result= new StringBuilder();
        switch (state){
            case Underside:
                for (Card card : deck){
                    result.append("Hided Card");
                    result.append("\n");
                }
                break;
            case Face_Side:
                for (Card card : deck){
                    if(deck.indexOf(card)== 0){
                        result.append(card.toString());
                    }else {
                        result.append("Hided Card");
                    }
                    result.append("\n");
                }
                break;
            case Unfolded:
                for (Card card : deck){
                    result.append(card.toString());
                    result.append("\n");
                }
        }
        return result.toString();
    }

    public Card pickRandom(){
        Random rand = new Random();
        int picked = rand.nextInt(deck.size());
        return deck.remove(picked);
    }
    public ArrayList<Card> pickRandom(int times){
        Random rand = new Random();
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i < times; i++){
            int picked = rand.nextInt(deck.size());
            cards.add(deck.remove(picked));
        }
        return cards;
    }

    public int countBlack(){
        int result = 0;
        for (Card card: deck){
            int i = card.getRank().getValue();
            if (card.getRank().name().equals("Ace")) {
                this.Ace = true;
            }
            result += i;
        }
    if(this.Ace){
            if(result <= 11){
                result += 10;
            }
        }
        return result;
    }

    public void AddCard(Card card){
        deck.add(card);
    }

    public void AddCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void ChangeState (State state){
        this.state = state;
    }
}
