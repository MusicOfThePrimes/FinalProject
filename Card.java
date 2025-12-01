/**
 * Represents a playing card with a suit, rank, and numerical value.
 * <p>
 * This class is commonly used in card games like blackjack, poker, and others.
 * Each card has a suit (e.g., Hearts, Spades), a rank (e.g., Ace, 2, King),
 * and a corresponding integer value.
 * </p>
 * 
 * @author Huilin Reid
 * @since 11-18-2025
 * 
 */

public class Card {
    private String suit;
    private String rank;
    private int value;

    /**
     * Constructs a new Card with the specified suit, rank, and value.
     *
     * @param suit  the suit of the card (e.g., "Hearts", "Diamonds")
     * @param rank  the rank of the card (e.g., "Ace", "2", "King")
     * @param value the numerical value of the card (used for game logic)
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * Returns the numerical value of the card.
     *
     * @return the value of the card as an integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank as a string
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit as a string
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * Returns a string representation of the card in the format "Rank of Suit".
     *
     * @return a string describing the card, e.g., "Ace of Spades"
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
