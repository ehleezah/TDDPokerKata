package Main;

public class Hand {

    Card[] handCards;
    private int combination;
    private int highCard;

    public Hand(Card[] handCards) {
        this.handCards = handCards;
        sortHandCards();
    }

    public void printHand() {
        for (Card handCard : handCards) {
            System.out.print(handCard + " ");
        }
    }

    private void sortHandCards() {
        for (int index = 0; index < handCards.length; index++) {
            int indexOfMinimum = index, minimum = getFace(index);
            for (int x = index + 1; x < handCards.length; x++) {
                if (getFace(x) < minimum) {
                    minimum = getFace(x);
                    indexOfMinimum = x;
                }
            }
            Card temp = getCard(index);
            handCards[index] = getCard(indexOfMinimum);
            handCards[indexOfMinimum] = temp;
        }
    }

    public int getFace(int index) {
        return handCards[index].getFace();
    }

    public char getSuit(int index) {
        return handCards[index].getSuit();
    }

    public void setCombination(int combination) {
        this.combination = combination;
    }

    public int getCombination() {
        return combination;
    }

    public void setHighCard(int index) {
        highCard = index;
    }

    public int getHighCard() {
        return highCard;
    }

    public Card getCard(int index) {
        return handCards[index];
    }

}
