package Main;

import java.util.Random;

public class DeckOfCard {

    private static final int CardsNumber = 52;
    private static final Random randomNumbersGenrator = new Random();
    private Card[] deckOfCards;

    public DeckOfCard() {
        int[] faces = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        char[] suits = {'H', 'D', 'C', 'S'};
        deckOfCards = new Card[CardsNumber];

        for (int index = 0; index < deckOfCards.length; index++) {
            deckOfCards[index] = new Card(faces[index % faces.length], suits[index / faces.length]);
        }
    }

    public void shuffleCard() {
        for (int index = 0; index < deckOfCards.length; index++) {
            int second = randomNumbersGenrator.nextInt(CardsNumber);
            Card temp = deckOfCards[index];
            deckOfCards[index] = deckOfCards[second];
            deckOfCards[second] = temp;
        }
    }

    public Card[][] dealCards() {
        int cardsCount = 5;
        Card[][] hands = new Card[2][1];
        Card[] hand1 = new Card[cardsCount];
        Card[] hand2 = new Card[cardsCount];
        System.arraycopy(deckOfCards, 0, hand1, 0, hand1.length);
        System.arraycopy(deckOfCards, cardsCount, hand2, 0, hand2.length);
        hands[0] = hand1;
        hands[1] = hand2;
        return hands;
    }

    public Card[] getDeck() {
        return deckOfCards;
    }
}
