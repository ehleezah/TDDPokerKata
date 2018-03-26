
import Main.Card;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CardTest {

    Card card;

    @Before
    public void initCard() {
        card = new Card(9, 'D');
    }

    @Test
    public void isCardCreated() {
        assertNotNull(card);
    }

    @Test
    public void isGettingTheRightCard() {
        assertEquals("A", card.valueToCard(14));
    }

    @After
    public void destroyCard() {
        card = null;
    }

}
