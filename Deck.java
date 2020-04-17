package application;

import java.util.Collections;
import java.util.Stack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Deck {
        private Card card_green_1,card_green_2,card_green_3,card_green_4,card_green_5,card_green_6,card_green_7,card_green_Draw_2;
        private Card card_blue_1,card_blue_2,card_blue_3,card_blue_4,card_blue_5,card_blue_6,card_blue_7,card_blue_Draw;
	private Card card_red_1,card_red_2,card_red_3,card_red_4,card_red_5,card_red_6,card_red_7,card_red_Draw;
        private Card card_yellow_1,card_yellow_2,card_yellow_3,card_yellow_4,card_yellow_5,card_yellow_6,card_yellow_7,card_yellow_Draw_2;
	
	private Card wildCard1;
	private Card wildCard2;
	private Card wildCard3;
	private Card wildCard4;
	private Stack<Card> drawPile;
	private Stack<Card> discardPile;
	private Stack<ImageView> discardPileView;
	private Stack<ImageView> drawPileView;

	public Stack<ImageView> getDiscardPileView() {
		return discardPileView;
	}

	public void setDiscardPileView(Stack<ImageView> discardPileView) {
		this.discardPileView = discardPileView;
	}

	public Stack<ImageView> getDrawPileView() {
		return drawPileView;
	}

	public void setDrawPileView(Stack<ImageView> drawPileView) {
		this.drawPileView = drawPileView;
	}

	public Stack<Card> getDrawPile() {
		return drawPile;
	}

	public Stack<Card> getDiscardPile() {
		return discardPile;
	}

	public Deck() {
		
		card_red_1 = new Card("RED_ONE", "red", "cardimages/1_red.jpg",1);

		card_red_2 = new Card("RED_TWO", "red", "cardimages/2_red.jpg",2);

		card_red_3 = new Card("RED_THREE", "red", "cardimages/3_red.jpg",3);

		card_red_4 = new Card("RED_FOUR", "red", "cardimages/4_red.jpg",4);

		card_red_5 = new Card("RED_FIVE", "red", "cardimages/5_red.jpg",5);

		card_red_6 = new Card("RED_SIX", "red", "cardimages/6_red.jpg",6);

		card_red_7 = new Card("RED_SEVEN", "red", "cardimages/7_red.jpg",7);

		card_red_Draw = new Card("RED_ONE_PLUS", "red", "cardimages/1_plus_red.jpg",0);

		card_blue_1 = new Card("BLUE_ONE", "blue", "cardimages/1_blue.jpg",1);

		card_blue_2 = new Card("BLUE_TWO", "blue", "cardimages/2_blue.jpg",2);

		card_blue_3 = new Card("BLUE_THREE", "blue", "cardimages/3_blue.jpg",3);

		card_blue_4 = new Card("BLUE_FOUR", "blue", "cardimages/4_blue.jpg",4);

		card_blue_5 = new Card("BLUE_FIVE", "blue", "cardimages/5_blue.jpg",5);

		card_blue_6 = new Card("BLUE_SIX", "blue", "cardimages/6_blue.jpg",6);

		card_blue_7 = new Card("BLUE_SEVEN", "blue", "cardimages/7_blue.jpg",7);

		card_blue_Draw = new Card("BLUE_ONE_PLUS", "blue", "cardimages/1_plus_blue.jpg",0);

		card_yellow_1 = new Card("YELLOW_ONE", "yellow", "cardimages/1_yellow.jpg",1);

		card_yellow_2 = new Card("YELLOW_TWO", "yellow", "cardimages/2_yellow.jpg",2);

		card_yellow_3 = new Card("YELLOW_THREE", "yellow", "cardimages/3_yellow.jpg",3);

		card_yellow_4 = new Card("YELLOW_FOUR", "yellow", "cardimages/4_yellow.jpg",4);

		card_yellow_5 = new Card("YELLOW_FIVE", "yellow", "cardimages/5_yellow.jpg",5);

		card_yellow_6 = new Card("YELLOW_SIX", "yellow", "cardimages/6_yellow.jpg",6);

		card_yellow_7 = new Card("YELLOW_SEVEN", "yellow", "cardimages/7_yellow.jpg",7);

		card_yellow_Draw_2 = new Card("YELLOW_TWO_PLUS", "yellow", "cardimages/2_plus_yellow.jpg",0);

		card_green_1 = new Card("GREEN_ONE", "green", "cardimages/1_green.jpg",1);

		card_green_2 = new Card("GREEN_TWO", "green", "cardimages/2_green.jpg",2);

		card_green_3 = new Card("GREEN_THREE", "green", "cardimages/3_green.jpg",3);

		card_green_4 = new Card("GREEN_FOUR", "green", "cardimages/4_green.jpg",4);

		card_green_5 = new Card("GREEN_FIVE", "green", "cardimages/5_green.jpg",5);

		card_green_6 = new Card("GREEN_SIX", "green", "cardimages/6_green.jpg",6);

		card_green_7 = new Card("GREEN_SEVEN", "green", "cardimages/7_green.jpg",7);

		card_green_Draw_2 = new Card("GREEN_TWO_PLUS", "green", "cardimages/2_plus_green.jpg",0);

		wildCard1 = new Card("WILD_MONSTER", "", "cardimages/wild.jpg",0);

		wildCard2 = new Card("WILD_MONSTER", "", "cardimages/wild.jpg",0);

		wildCard3 = new Card("WILD_MONSTER", "", "cardimages/wild.jpg",0);

		wildCard4 = new Card("WILD_MONSTER", "", "cardimages/wild.jpg",0);

		drawPile = new Stack<Card>();
		discardPile = new Stack<Card>();
		drawPileView = new Stack<ImageView>();
		discardPileView = new Stack<ImageView>();
	
		//adding cards to deck
                Collections.addAll(drawPile,card_red_1,card_red_2,card_red_3,card_red_4,card_red_5,card_red_6,card_red_7,card_red_Draw);
                Collections.addAll(drawPile,card_blue_1,card_blue_2,card_blue_3,card_blue_4,card_blue_5,card_blue_6,card_blue_7,card_blue_Draw);
                Collections.addAll(drawPile,card_yellow_1,card_yellow_2,card_yellow_3,card_yellow_4,card_yellow_5,card_yellow_6,card_yellow_7,card_yellow_Draw_2);
                Collections.addAll(drawPile,card_green_1,card_green_2,card_green_3,card_green_4,card_green_5,card_green_6,card_green_7,card_green_Draw_2);
                
                //adding wild cards
		drawPile.add(wildCard1);

		drawPile.add(wildCard2);
		
		drawPile.add(wildCard3);
		
		drawPile.add(wildCard4);

	

	}
        
        	public void shuffleDrawPile() {
	
		if (discardPile.size() > 0) {
                        int index=0;
			while(index < discardPile.size())
                        {
				drawPile.push(discardPile.pop());
                                index++;
                        }
			
		}
                int index=0;
		while(index < drawPile.size()) {
			if (drawPile.get(index).getCardName().equals("WILD_MONSTER") && drawPile.get(index).getCardColor() != null) {
				drawPile.get(index).setColor(null);
			}
                        index++;
		}
		Collections.shuffle(drawPile);
	}

	public void reshuffle(){
		if (discardPile.size() > 0) {
                        int index=discardPile.size()-2;
			while( index >=0)
				drawPile.push(discardPile.remove(index--));
                              
			
		}
                int index=0;
                while(index < drawPile.size())
		{
			if (drawPile.get(index).getCardName().equals("WILD_MONSTER") && drawPile.get(index).getCardColor() != null) {
				drawPile.get(index).setColor(null);
                                
			}
                        index++;
		}
                
                //shuffle the card as it is not a number
		Collections.shuffle(drawPile);
                index=0;
		while (index < drawPile.size() ) {
			drawPileView.add(index, new ImageView(drawPile.get(index).getCardPicture()));
                        index++;
		}
		
	}
        
        //putting cards facing down
	public void drawPileFaceDown() {
                int index=0;
		while(index < drawPile.size()) {
			drawPile.get(index).setCardFaceDown(true);
                        index++;
		}

	}

        //drawing card from pile to decide player to start the game
	public void turnFaceUpToStartGame() {
		while (true) {
			drawPile.peek().setCardFaceDown(false);
			if ((drawPile.peek().getCardValue()) == 0) {
				getDiscardPile().add(drawPile.pop());
				
				
			} else {
				getDiscardPile().add(drawPile.pop());
				
				break;
			}
		}

	}

}
