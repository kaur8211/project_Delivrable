package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {

	private String cardName;
	private String cardColor;
	private int cardNo;
	

	
	private Image image;
	private Image cardBackSideImage;
        private boolean cardFaceDown=false;
        
	public Card(String cardName, String cardColor, String cardImage,int cardNo) throws IllegalArgumentException{
		this.image=new Image(cardImage, 170, 170, true, true);
		this.cardName = cardName;
		this.cardColor = cardColor;
		this.cardBackSideImage=new Image("cardimages/back.jpg", 170, 170, true, true);
                this.cardNo=cardNo;
                
	}
	
	public String getCardName() {
		return cardName;
	}

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }
   
	public String getCardColor() {
		return cardColor;
	}

	public int getCardValue() {
		return cardNo;
	}
	
	public Image getCardPicture() {
		return image;
	}
	public Image getCardBackSidePhoto() {
		return cardBackSideImage;
	}

        public void setCardFaceDown(boolean cardFace) {
		this.cardFaceDown = cardFace;
	}

		
	public void setColor(String cardColor) {
		this.cardColor = cardColor;
	}

	
	public String toString(){
		
		return "Card Value:"+this.getCardValue()+" Card Color:"+ this.getCardColor(); 
		
	}

}
