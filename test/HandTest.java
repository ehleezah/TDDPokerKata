
import Main.Card;
import Main.Hand;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HandTest {

    Hand hand;

    @Before
    public void initHand() {

        int[] faces = {3, 6, 9, 8, 4};
        char[] suit = {'C', 'D', 'H', 'S'};
        Card[] cards = cards(faces, suit);

        hand = new Hand(cards);
    }

    public Card[] cards(int[] faces, char[] suit) {
        Card[] cards = new Card[5];
        for (int i = 0; i < cards.length; i++) {
            if (i == 4) {
                cards[i] = new Card(faces[i], suit[i - 1]);
            } else {
                cards[i] = new Card(faces[i], suit[i]);
            }
        }
        return cards;
    }

    @Test
    public void isHandCreated() {
        assertNotNull(hand);
    }

    @Test
    public void sortTest() {
        Card pokerCard = new Card(hand.getFace(1), hand.getSuit(1));
        Card anotherCard = new Card(6, 'D');
        assertNotEquals(pokerCard, anotherCard);
    }

    @Test
    public void isCombinationWorking() {
        hand.setCombination(2);
        assertEquals(2, hand.getCombination(), 0);
    }

    @After
    public void destroyHand() {
        hand = null;
    }

}
