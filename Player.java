package application;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Player {

	
	private ArrayList<Card> cards;
	private ArrayList<ImageView> cardsView;
	private boolean firstPlayer = false;
        private String playerName;
	
	public Player(String playerName) {
		this.playerName = playerName;
		cards = new ArrayList<Card>();
		cardsView = new ArrayList<ImageView>();
		
	}

        public void setFirstPlayer(boolean firstPlayer) {
            this.firstPlayer = firstPlayer;
        }

	public boolean isFirstPlayer() {
		return firstPlayer;
	}

	public Card discard(Card discarded) throws IllegalArgumentException {

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).equals(discarded)) {
				return cards.remove(i);
				
			}
		}
		throw new IllegalArgumentException("You don't have that card");

	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void draw(Card drawn) {

		cards.add(drawn);

	}
	public void draw(ImageView drawn) {

		cardsView.add(drawn);

	}

	public ArrayList<ImageView> getCardsView() {
		return cardsView;
	}

	public String toString() {
	
		return playerName;
	}

}
