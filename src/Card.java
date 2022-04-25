public class Card {
    private final Rank rank;
    private final Suit suit;

    Card (Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        String unicode = "DC" + suit.getLabel() + rank.getLabel();
        int hexVal = Integer.parseInt(unicode, 16);
       return rank.name() + " of " + suit.name() +" \uD83C" +(char)hexVal;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
