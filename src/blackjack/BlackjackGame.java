package blackjack;

import java.util.ArrayList;
import java.util.List;

/*
A simplified version of Blackjack
Each player will automatically hit another card if current score is below 16.
If the final score of a player is not above 21, he/she is a winner.
 */
public class BlackjackGame {
	public static void main(String[] args) {
		BlackjackGame game = new BlackjackGame(3);
		List<Integer> winners = game.game();
		System.out.println("The winners are: " + winners);
	}

	private Deck deck;
	private List<BlackjackHand> players;
	public final int HIT_UNTIL = 19;
	private List<Integer> winners;

	public BlackjackGame(int numberOfPlayers) {
		initDeck();
		players = new ArrayList<>();
		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new BlackjackHand());
		}
		winners = new ArrayList<>();
	}

	public List<Integer> game() {
		dealInitial();
		playHands();
		return winners;
	}

	private void initDeck() {
		deck = new Deck();
		deck.shuffle();
	}

	private void dealInitial() {
		winners.clear();
		for (Hand hand : players) {
			List<Card> cards = deck.dealHand(2);
//			if (cards == null) {
//				throw new Exception("Not enough cards");
//			}
			hand.addCards(cards);
		}
	}

	private void playHands() {
		for (int i = 0; i < players.size(); i++) {
			if (playHand(players.get(i))) {
				winners.add(i);
			}
		}
	}

	private boolean playHand(BlackjackHand hand) {
		if (hand.isBlackjack()) {
			return true;
		}
		int score = hand.getScore();
		while (score < HIT_UNTIL) {
			hand.hit(deck.dealCard());
			score = hand.getScore();
		}
		boolean hasWon = score <= 21;
		hand.setCompleteGame(hasWon);
		return hasWon;
	}
}
