
import Main.Card;
import Main.Hand;
import Main.PokerHands;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PokerHandsTest {

    PokerHands pokerHand;

    @Before
    public void init() {
        String blackDeck = "3D:2H:9C:KD:9S";
        String whiteDeck = "AH:3H:2C:4S:8C ";

        Hand blackHand = new Hand(pokerhand(blackDeck));
        Hand whiteHand = new Hand(pokerhand(whiteDeck));

        pokerHand = new PokerHands(blackHand, whiteHand);
    }

    public Card[] pokerhand(String str) {
        String[] cards = str.split(":");
        String[] someJorr = new String[2];
        Card[] hand = new Card[5];
        for (int i = 0; i < cards.length; i++) {
            someJorr = cards[i].split("(?!^)");
            hand[i] = new Card(cardFace(someJorr[0]), someJorr[1].charAt(0));
        }

        return hand;
    }

    public int cardFace(String cardCode) {
        int value = 0;
        if (Character.isDigit(cardCode.charAt(0))) {
            value = Integer.parseInt(cardCode);
        } else {
            switch (cardCode.charAt(0)) {
                case 'T':
                    value = 10;
                case 'J':
                    value = 11;
                    break;
                case 'Q':
                    value = 12;
                    break;
                case 'K':
                    value = 13;
                    break;
                case 'A':
                    value = 14;
                    break;
                default:
                    value = 0;
            }
        }
        return value;
    }

    @Test
    public void givenPokerHands_WhenInstantiatingObject_ThenObjectCreated() {
        assertNotNull(pokerHand);
    }

    @Test
    public void isPair() throws Exception {
        String black = "2H:3D:9S:9C:KD";
        String white = "2C:3H:4S:8C:AH";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();
        assertEquals(1, testingPokerHand.playerOne.getCombination());
        assertEquals(9, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isTwoPair() throws Exception {
        String black = "3S:3H:8C:8S:KD";
        String white = "2C:3H:4S:8C:AH";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(2, testingPokerHand.playerOne.getCombination());
        assertEquals(8, testingPokerHand.playerOne.getHighCard());

    }

    @Test
    public void isThreeOfAKind() throws Exception {
        String black = "AS:AC:2H:9D:AH";
        String white = "2C:8C:AH:3H:4S";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(3, testingPokerHand.playerOne.getCombination());
        assertEquals(14, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isStraight() throws Exception {
        String black = "2D:3S:4C:5H:AD";
        String white = "2C:3H:4S:8C:5H";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(4, testingPokerHand.playerOne.getCombination());
        assertEquals(5, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isFlush() throws Exception {
        String black = "4H:3H:8H:9H:KH";
        String white = "2D:6D:4S:7D:AH";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(5, testingPokerHand.playerOne.getCombination());
        assertEquals(13, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isFullHouse() throws Exception {
        String black = "3k:3J:3K:7S:7D";
        String white = "4S:AH:2C:8C:3H";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(6, testingPokerHand.playerOne.getCombination());
        assertEquals(3, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isFourOfAKind() throws Exception {
        String black = "7S:7D:7H:7C:8D";
        String white = "2C:3H:AH:4S:8C";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(7, testingPokerHand.playerOne.getCombination());
        assertEquals(7, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void isStraightFlush() throws Exception {
        String black = "2D:3D:4D:5D:9D";
        String white = "2C:3H:AH:4S:8C";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals(5, testingPokerHand.playerOne.getCombination());
        assertEquals(9, testingPokerHand.playerOne.getHighCard());
    }

    @Test
    public void getWinner() throws Exception {
        String black = "2C:3H:4S:8C:AH";
        String white = "2H:3D:5S:9C:KD";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();
        assertEquals("Black", testingPokerHand.getWinner());
    }

    @Test
    public void getTie() throws Exception {
        String black = "2D:3H:5C:9S:KH";
        String white = "2H:3D:5S:9C:KD";

        Hand blackHand = new Hand(pokerhand(black));
        Hand whiteHand = new Hand(pokerhand(white));
        PokerHands testingPokerHand = new PokerHands(blackHand, whiteHand);
        testingPokerHand.evaluateHands();

        assertEquals("Tie", testingPokerHand.getWinner());

    }
}
