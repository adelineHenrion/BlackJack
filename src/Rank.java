public enum Rank {
    Ace('1',1),
    Two('2', 2),
    Three('3', 3),
    Four('4', 4),
    Five('5', 5),
    Six('6', 6),
    Seven('7', 7),
    Height('8', 8),
    Nine('9', 9),
    Ten('A', 10),
    Jack('B', 10),
    Queen('D', 10),
    King('E', 10);

    public final char label;
    public final int value;

    Rank(char label, int value) {
        this.label = label;
        this.value = value;
    }

    public char getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }
}
