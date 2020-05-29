package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	final protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public void hit(Card card) {
		cards.add(card);
	}

	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}

	public int getScore() {
		int total = 0;
		for (Card card : cards) {
			total += card.getRank().value;
		}
		return total;
	}

	public int getCount() {
		return cards.size();
	}

	public void reset() {
		cards.clear();
	}
}
