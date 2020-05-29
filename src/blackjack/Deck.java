package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	private final List<Card> deck;
	private int dealIndex;

	public Deck() {
		deck = new ArrayList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		shuffle();
	}

	public Card dealCard() {
		if (isEmpty()) {
			return null;
		}
		return deck.get(dealIndex++);
	}

	public List<Card> dealHand(int count) {
		if (getRemainCount() < count) {
			return null;
		}
		List<Card> hand = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			hand.add(deck.get(dealIndex++));
		}
		return hand;
	}

	public void shuffle() {
		Random random = new Random();
		for (int i = 0; i < deck.size(); i++) {
			swap(i, random.nextInt(deck.size()));
		}
		dealIndex = 0;
	}

	public boolean isEmpty() {
		return dealIndex == deck.size();
	}

	public int getRemainCount() {
		return deck.size() - dealIndex;
	}

	private void swap(int i, int j) {
		Card tmp = deck.get(i);
		deck.set(i, deck.get(j));
		deck.set(j, tmp);
	}
}
