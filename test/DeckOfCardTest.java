

import Main.Card;
import Main.DeckOfCard;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;


public class DeckOfCardTest {
	
	DeckOfCard deck;
	
	@Before
	public void initDeck(){
		deck = new DeckOfCard();
	}
	
	@Test
	public void isDeckCreated(){
		assertNotNull(deck);
	}
	
	@Test
	public void isGettingRightSizeDeck(){
		assertEquals(52, deck.getDeck().length);
	}
	
	@Test
	public void isShuffleWorking(){
		Card deckBeforeShuffle = deck.getDeck()[0];
                deck.shuffleCard();
		Card deckCardafterShuffle = deck.getDeck()[0];
		assertFalse((deckBeforeShuffle.getFace() == deckCardafterShuffle.getFace()) && (deckBeforeShuffle.getSuit() == deckCardafterShuffle.getSuit()));
	}
	
	@Test
	public void isDealCardWorking(){
		Card[][] pokerHands = deck.dealCards();
		assertArrayEquals(pokerHands, deck.dealCards());
	}
	
	@After
	public void destroyDeck(){
		deck = null;
	}
	
}
