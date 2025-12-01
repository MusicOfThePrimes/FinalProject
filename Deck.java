
/**
 * Represents a deck of playing cards.
 * <p>
 * This class supports multiple decks and provides methods to shuffle,
 * draw cards, and check the remaining size of the deck. It uses the {@link Card} class
 * to represent individual cards.
 * </p>
 * 
 * @author Huilin Reid
 * @since 11-18-2025
 * 
 */

import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    /**
     * Constructs a deck containing the specified number of standard 52-card decks.
     * <p>
     * Each deck contains cards for all four suits (Hearts, Diamonds, Clubs, Spades)
     * and thirteen ranks (2-10, J, Q, K, A). After creating the cards, the deck
     * is shuffled automatically.
     * </p>
     *
     * @param numberOfDecks the number of 52-card decks to include
     */
    public Deck(int numberOfDecks) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] values =  {2,3,4,5,6,7,8,9,10,10,10,10,11};

        for (int d = 0; d < numberOfDecks; d++) {
            for (String suit : suits) {
                for (int i = 0; i < ranks.length; i++) {
                    cards.add(new Card(suit, ranks[i], values[i]));
                }
            }
        }
        shuffle();
    }

    /**
     * Shuffles the deck randomly.
     * <p>
     * This method uses {@link Collections#shuffle(List)} to reorder the cards.
     * </p>
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws (removes and returns) the top card from the deck.
     * 
     * @return the top {@link Card} from the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty!");
        }
        return cards.remove(0);
    }

    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the number of remaining cards
     */
    public int size() {
        return cards.size();
    }
}
