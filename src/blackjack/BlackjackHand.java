package blackjack;

import java.util.List;

public class BlackjackHand extends Hand {
	static class Score {
		int score1 = 0;
		int score2 = 0;
	}

	private boolean completed = false;
	private boolean hasWon = false;
	private Score score;

	public BlackjackHand() {
		super();
		score = new Score();
	}

	@Override
	public void hit(Card card) {
		super.hit(card);
		updateScore(card);
	}

	@Override
	public void addCards(List<Card> cards) {
		super.addCards(cards);
		for (Card card : cards) {
			updateScore(card);
		}
	}

	private void updateScore(Card card) {
		if (card == null) {
			return;
		}
		Rank rank = card.getRank();
		if (rank.equals(Rank.Ace)) {
			score.score1 += 1;
			score.score2 += 11;
		} else {
			int num = Math.min(rank.value, 10);
			score.score1 += num;
			score.score2 += num;
		}
	}

	@Override
	public int getScore() {
		return score.score1 > 16 && score.score1 <= 21 ? score.score1 : score.score2;
	}

	public boolean isBlackjack() {
		if (cards.size() != 2) {
			return false;
		}
		Card card1 = cards.get(0);
		Card card2 = cards.get(1);
		return card1.getRank().equals(Rank.Ace) && card2.getRank().value >= 10 || card2.getRank().equals(Rank.Ace) && card1.getRank().value >= 10;
	}

	public void setCompleteGame(boolean hasWon) {
		completed = true;
		this.hasWon = hasWon;
	}

	public boolean hasWon() {
		return hasWon;
	}

	public boolean completed() {
		return completed;
	}
}
