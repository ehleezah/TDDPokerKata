package Main;

public class PokerHands {

    public Hand playerOne, playerTwo;
    private final int numberOfCards = 5;

    public PokerHands(Hand playerOne, Hand playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void evaluateHands() {
        getCombination(playerOne);
        getCombination(playerTwo);
    }

    private void getCombination(Hand player) {
        if (hasStraightFlush(player)) {
            player.setCombination(8);
            int temp = player.getFace(4) == 14 && player.getFace(3) == 5 ? 5 : player.getFace(4);
            player.setHighCard(temp);
        } else if (hasFourOfAKind(player)) {
            player.setCombination(7);
            player.setHighCard(player.getFace(1));
        } else if (hasFullHouse(player)) {
            player.setCombination(6);
            player.setHighCard(player.getFace(2));
        } else if (hasFlush(player)) {
            player.setCombination(5);
            player.setHighCard(player.getFace(4));
        } else if (hasStraight(player)) {
            player.setCombination(4);
            int temp = player.getFace(4) == 14 && player.getFace(3) == 5 ? 5 : player.getFace(4);
            player.setHighCard(temp);
        } else if (hasThreeOfAKind(player)) {
            player.setCombination(3);
            player.setHighCard(player.getFace(2));
        } else if (hasTwoPair(player)) {
            player.setCombination(2);
            player.setHighCard(player.getFace(3));
        } else if (hasPair(player)) {
            player.setCombination(1);
            if (isPair(player.getCard(0), player.getCard(1)) || isPair(player.getCard(2), player.getCard(1))) {
                player.setHighCard(player.getFace(1));
            } else {
                player.setHighCard(player.getFace(3));
            }
        } else {
            player.setHighCard(player.getFace(4));
        }
    }

    private boolean hasStraightFlush(Hand player) {
        return hasFlush(player) && hasStraight(player);
    }

    private boolean hasFourOfAKind(Hand player) {
        for (int index = 0; index < numberOfCards - 3; index++) {
            if (isThreeOfAKind(player.getCard(index), player.getCard(index + 1), player.getCard(index + 2))
                    && isPair(player.getCard(index + 2), player.getCard(index + 3))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasFullHouse(Hand player) {
        return (isPair(player.getCard(0), player.getCard(1))
                && isThreeOfAKind(player.getCard(2), player.getCard(3), player.getCard(4))
                || (isPair(player.getCard(3), player.getCard(4))
                && isThreeOfAKind(player.getCard(0), player.getCard(1), player.getCard(2))));
    }

    private boolean hasFlush(Hand player) {
        for (int index = 0; index < numberOfCards - 1; index++) {
            if (player.getSuit(index) != player.getSuit(index + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStraight(Hand player) {
        for (int index = numberOfCards - 1; index > 0; index--) {
            int faceOne = player.getFace(index);
            int faceTwo = player.getFace(index - 1);
            
            if (!(faceOne == 14 && faceTwo == 5) && faceOne - faceTwo != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasThreeOfAKind(Hand player) {
        for (int index = 0; index < numberOfCards - 2; index++) {
            if (isThreeOfAKind(player.getCard(index), player.getCard(index + 1), player.getCard(index + 2))) {
                return true;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(Card card1, Card card2, Card card3) {
        return card1.getFace() == card2.getFace() && card2.getFace() == card3.getFace();
    }

    private boolean hasTwoPair(Hand player) {
        for (int index = 0; index < numberOfCards - 3; index++) {
            if (isPair(player.getCard(index), player.getCard(index + 1))) {
                for (int indexTwo = index + 2; indexTwo < numberOfCards - 1; indexTwo++) {
                    if (isPair(player.getCard(indexTwo), player.getCard(indexTwo + 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasPair(Hand player) {
        for (int index = 0; index < numberOfCards - 1; index++) {
            if (isPair(player.getCard(index), player.getCard(index + 1))) {
                return true;
            }
        }
        return false;
    }

    private boolean isPair(Card card1, Card card2) {
        return card1.getFace() == card2.getFace();
    }

    public String getWinner() {
        if (playerOne.getCombination() == playerTwo.getCombination()) {
            if (playerOne.getHighCard() == playerTwo.getHighCard()) {
                return evaluateTie();
            } else {
                return playerOne.getHighCard() > playerTwo.getHighCard() ? "Black" : "White";
            }
        } else {
            return playerOne.getCombination() > playerTwo.getCombination() ? "Black" : "White";
        }
    }

    private String evaluateTie() {
        for (int index = numberOfCards - 1; index >= 0; index--) {
            if (playerOne.getFace(index) != playerTwo.getFace(index)) {
                return playerOne.getFace(index) > playerTwo.getFace(index) ? "Black" : "White";
            }
        }
        return "Tie";
    }
}
