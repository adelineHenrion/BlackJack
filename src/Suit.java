 enum Suit {
    Spades('A'),
     Hearts('B'),
     Diamonds('C'),
     Clubs('D');

    private final char label;

     public char getLabel() {
         return label;
     }

     Suit(char label){
        this.label = label;

    }
}
