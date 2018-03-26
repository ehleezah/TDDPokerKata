package Main;

public class Card {

    private final Integer cardFace;
    private final char cardSuit;

    public Card(int face, char suit) {
        this.cardFace = face;
        this.cardSuit = suit;
    }

    public int getFace() {
        return cardFace;
    }

    public char getSuit() {
        return cardSuit;
    }

    public String valueToCard(int value) {
        String card = "";
        if (value < 10) {
            card += value;
        } else if (value == 10) {
            card = "T";
        } else if (value == 11) {
            card = "J";
        } else if (value == 12) {
            card = "Q";
        } else if (value == 13) {
            card = "K";
        } else if (value == 14) {
            card = "A";
        }

        return card;
    }

    @Override
    public String toString() {
        return valueToCard(getFace()) + "" + getSuit();
    }
}
