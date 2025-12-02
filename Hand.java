/**
 * Represents a hand of playing cards in a card game such as blackjack.
 * 
 * This class tracks the cards in a hand, calculates the total value
 * according to blackjack rules, detects blackjack, and checks for busts.
 * 
 * @author Huilin Reid
 * @since 11-18-2025
 * 
 */

import java.util.*;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    /**
     * Adds a card to the hand.
     *
     * @param card the Card to add
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Returns the first card in the hand.
     *
     * @return the first Card added to the hand
     */
    public Card getFirstCard() {
        return cards.get(0);
    }

    /**
     * Calculates the total value of the hand according to blackjack rules.
     * 
     * Aces are counted as 11 unless the total exceeds 21, in which case
     * each ace is reduced to a value of 1 as needed to avoid busting.
     *
     * @return the total numerical value of the hand
     */
    public int getValue() {
        int sum = 0;
        int aceCount = 0;
        for (Card c : cards) {
            sum += c.getValue();
            if (c.getRank().equals("A")) {
                aceCount++;
            }
        }

        // Adjust aces from 11 to 1 if total exceeds 21
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }
        return sum;
    }

    /**
     * Checks if the hand is a bust (total value exceeds 21).
     *
     * @return true if the hand value is greater than 21, false otherwise
     */
    public boolean isBust() {
        return getValue() > 21;
    }

    /**
     * Checks if the hand is a blackjack (two cards totaling 21).
     *
     * @return true if the hand has exactly two cards and the total is 21, false otherwise
     */
    public boolean isBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }

    /**
     * Returns a string representation of the hand.
     *
     * @return a string listing all cards in the hand and the total value, e.g.,
     *         "[Ace of Spades, 10 of Hearts] (Total: 21)"
     */
    @Override
    public String toString() {
        return cards.toString() + " (Total: " + getValue() + ")";
    }
}
