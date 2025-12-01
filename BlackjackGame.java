/**
 * A simple console-based Blackjack game in Java.
 * <p>
 * This class allows a single player to play against a dealer (the computer) using one or more decks.
 * The game follows standard blackjack rules:
 * <ul>
 *   <li>Player aims to beat the dealer without going over 21.</li>
 *   <li>Blackjack ("natural") occurs when the first two cards are an Ace and a 10-value card.</li>
 *   <li>Dealer must hit until reaching at least 17.</li>
 *   <li>Player can hit, stand, or walk away on their turn.</li>
 * </ul>
 * </p>
 * <p>
 * The game automatically reshuffles the deck if fewer than 15 cards remain.
 * </p>
 * 
 * @author Huilin Reid
 * @since 11-18-2025
 * 
 */

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new BlackjackGame instance.
     */
    public BlackjackGame() {
    }

    /**
     * Starts the game, allowing the player to choose the number of decks
     * and play multiple rounds until they choose to stop.
     */
    public void start() {
        System.out.println("\n============= Welcome to Java Blackjack =============\n");
        System.out.println("Rules: Beat the dealer without going over 21.\n");

        int numDecks = readInt("Enter number of decks (1-8): ", 1, 8);
        deck = new Deck(numDecks);

        boolean keepPlaying = true;
        while (keepPlaying) {
            playRound();
            System.out.print("\n------------------------------------------------------");
            System.out.print("\nPlay another round? (y/n): ");
            keepPlaying = scanner.nextLine().trim().equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!\n");
    }

    /**
     * Reads an integer input from the user within a specified range.
     *
     * @param prompt the message to display to the user
     * @param min    minimum acceptable value
     * @param max    maximum acceptable value
     * @return the validated integer input from the user
     */
    private int readInt(String prompt, int min, int max) {
        int val = -1;
        while (val < min || val > max) {
            try {
                System.out.print(prompt);
                val = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
        return val;
    }

    /**
     * Plays a single round of blackjack.
     * <p>
     * Deals initial hands, handles player choices (hit, stand, walk away),
     * manages dealer behavior according to standard rules, determines
     * round outcome, and prints results.
     * </p>
     */
    private void playRound() {
        if (deck.size() < 15) {
            System.out.println("\nReshuffling deck...");
            deck = new Deck(1);
        }

        playerHand = new Hand();
        dealerHand = new Hand();

        // initial deal
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("\nYour hand: " + playerHand);
        System.out.println("Dealer shows: " + dealerHand.getFirstCard());

        if (playerHand.isBlackjack()) {
            System.out.println("Blackjack! You win!");
            return;
        }

        // Player turn
        while (true) {
            System.out.print("(h)it, (s)tand, or (w)alk away? ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Your hand: " + playerHand);
                if (playerHand.isBust()) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (choice.equals("s")) {
                break;
            } else if (choice.equals("w")) {
                System.out.println("You walked away.");
                return;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        // Dealer turn
        System.out.println("\nDealer's hand: " + dealerHand);
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.drawCard());
            System.out.println("Dealer hits: " + dealerHand);
        }

        if (dealerHand.isBust()) {
            System.out.println("Dealer busts! You win!");
            return;
        }

        int player = playerHand.getValue();
        int dealer = dealerHand.getValue();

        System.out.println();
        if (player > dealer) {
            System.out.println("You win! " + player + " beats " + dealer);
        } else if (player < dealer) {
            System.out.println("You lose. Dealer's " + dealer + " beats your " + player);
        } else {
            System.out.println("Push. Both have " + player);
        }
    }

    /**
     * Main method to launch the Blackjack game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new BlackjackGame().start();
    }
}
