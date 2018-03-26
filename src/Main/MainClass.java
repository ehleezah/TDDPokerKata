package Main;

public class MainClass {

    public static void main(String[] args) {
        DeckOfCard deck = new DeckOfCard();

        deck.shuffleCard();

        Card[][] hands = deck.dealCards();

        Hand black = new Hand(hands[0]);
        Hand white = new Hand(hands[1]);

        System.out.print("Black: ");
        black.printHand();

        System.out.print("White: ");
        white.printHand();

        PokerHands pokerHand = new PokerHands(black, white);
        pokerHand.evaluateHands();
        String result = pokerHand.getWinner();
        System.out.print(" " + result + " wins - ");
        System.out.println(formatResult(result, black, white));
    }

    public static String formatResult(String result, Hand black, Hand white) {
        Hand hand = null;
        String displayValue = "";
        hand = (result.equals("Black") ? black : white);
        int combination = hand.getCombination();
        if (combination == 8) {
            displayValue = "Straight Flush";
        } else if (combination == 7) {
            displayValue = "Four of a kind";
        } else if (combination == 6) {
            displayValue = "Full House";
        } else if (combination == 5) {
            displayValue = "Flush";
        } else if (combination == 4) {
            displayValue = "Straight";
        } else if (combination == 3) {
            displayValue = "Three of a kind";
        } else if (combination == 2) {
            displayValue = "Two Pairs";
        } else if (combination == 1) {
            displayValue = "Pair";
        } else if (combination == 0) {
            int highCard = hand.getHighCard();
            
            if (highCard == 10) {
                displayValue = "High Card: Ten";
            } else if (highCard == 11) {
                displayValue = "High Card: Jack";
            } else if (highCard == 12) {
                displayValue = "High Card: Queen";
            } else if (highCard == 13) {
                displayValue = "High Card: King";
            } else if (highCard == 13) {
                displayValue = "High Card: Ace";
            }
        }
        return displayValue;
    }
}
