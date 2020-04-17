package application;


import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.TextField;

public class UnoGameController implements Initializable {
	private int index;
	private int unoCounter = 0;
	private ViewUnoGame uno = new ViewUnoGame();
	private int counter = 0;
	private boolean wildCard;
	
	
	

	@FXML
	private StackPane discardPile;

	@FXML
	private StackPane drawPile;

	@FXML
	private HBox UserCardPile;

	@FXML
	private Button startButton;

	@FXML
	private TextField txtField;
        
        @FXML
	private HBox ComputerCardPile;

	void clearDeck() {
		if(uno.getComputer().getCards().get(0).getCardValue()==0||uno.getUser().getCards().get(0).getCardValue()==0){

			ImageView temp = new ImageView(uno.getComputer().getCards().get(0).getCardPicture());
			uno.getUnoDeck().getDiscardPile().push(uno.getComputer().getCards().remove(0));
			ComputerCardPile.getChildren().remove(0);

			discardPile.getChildren().add(temp);

			uno.getUnoDeck().getDiscardPile().push(uno.getUser().discard(uno.getUser().getCards().get(0)));
			discardPile.getChildren().add(UserCardPile.getChildren().remove(0));

			shuffleDeck();

			computerTakeCardFromPile();
			userTakeCard();
			
		}

	}
        
        //handling colour buttons
        @FXML
	void redButtonClicked() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("red");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.setText("Set color is red");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}
        
	@FXML
	void blueButtonClicked() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("blue");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.setText("Set color is blue");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;

		}

	}

	@FXML
	void greenButtonClicked() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("green");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.setText("Set color is green");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}

	

	@FXML
	void yellowButtonClicked() {
		if (wildCard == true) {
			uno.getCurrentCard().setColor("yellow");
			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
			txtField.setText("Set color is yellow");
			uno.setCurrentPlayer(uno.getComputer());
			wildCard = false;
		}
	}

	void shuffleDeck() {
		uno.getUnoDeck().reshuffle();
                int noOfDiscardedCards=discardPile.getChildren().size();
		if (noOfDiscardedCards > 0) {
                        index=0;
			while(index < noOfDiscardedCards - 1)
                        {
				discardPile.getChildren().remove(index);
                                index++;
                        }
		}
                
                int index=0;
                int numberOfCardsUnoDeck=uno.getUnoDeck().getDrawPile().size();

		while (index < numberOfCardsUnoDeck) {
			ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(index).getCardBackSidePhoto());
			drawPile.getChildren().add(index, temp);
                        index++;

		}
	}

	void shuffle() {
		uno.getUnoDeck().shuffleDrawPile();
		if (discardPile.getChildren().size() > 0)
			discardPile.getChildren().clear();

		UserCardPile.getChildren().clear();
		ComputerCardPile.getChildren().clear();
                int numberOfCards=uno.getUnoDeck().getDrawPile().size();
                int index=0;
		while(index < numberOfCards) {
			ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(index).getCardBackSidePhoto());
			drawPile.getChildren().set(index, temp);
                        index++;

		}
	}

	@FXML
	void playComputerTurn(MouseEvent event) {
		if (wildCard == false) {
			if (counter == 5) {
				if (uno.getCurrentPlayer() == uno.getComputer()) {

					
					computerTakeTurn();

				}
			}
		}
	}

	void computerTakeTurn() {
               
		if (wildCard == false) {
			if (uno.getCurrentPlayer().getCards().size() == 0) {
				txtField.setText("You Lost the Game");
				startButton.setText("Computer Won");
			}
			if (uno.getUnoDeck().getDrawPile().size() == 0)
				shuffleDeck();

			if (uno.getComputer().getCards().size() == 2) {
				String[] dumbComputer = { "", "uno" };
				String declare = dumbComputer[(int) (Math.random() * dumbComputer.length)];

				txtField.setText("Computer declared " + declare + " ! ");

				if (declare.equalsIgnoreCase("uno")) {

					txtField.setText("UNO Shouted by Computer");

				}
                                
				
			}
                         txtField.setText("Computer Played");
		}

		String[] color = { "yellow", "blue", "red", "green" };
		String computerChoice = "";

		for (int i = 0; i < uno.getComputer().getCards().size(); i++) {

			if (uno.checkWildCard(uno.getComputer().getCards().get(i)) == false)
				continue;
			if (uno.checkWildCard(uno.getComputer().getCards().get(i)) == true) {

				if (uno.getComputer().getCards().get(i).getCardName().equals("WILD_MONSTER")) {

					computerChoice = color[(int) (Math.random() * (color.length))];
					txtField.setText("Computer Changed the Color " + computerChoice);

					computerDiscard(i);

					uno.getUnoDeck().getDiscardPile().peek().setColor(computerChoice);

					uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
					if (uno.getCurrentPlayer().getCards().size() == 0) {
						txtField.setText("You Lost the Game");
						startButton.setText("Computer Won");
					}
					uno.setCurrentPlayer(uno.getUser());

					return;
				} else {
					computerDiscard(i);

					uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
					if (uno.getCurrentPlayer().getCards().size() == 0) {
						txtField.setText("You Lost the Game");
						startButton.setText("Computer Won");
					}
					uno.setCurrentPlayer(uno.getUser());
					return;
				}
			}

		}

		computerTakeCardFromPile();
		uno.setCurrentPlayer(uno.getUser());
		return;

	}
        
        void userTakeCard() {
		ImageView pass = new ImageView(uno.getUnoDeck().getDrawPile().peek().getCardPicture());
		uno.getUser().draw(uno.getUnoDeck().getDrawPile().pop());
		drawPile.getChildren().remove(drawPile.getChildren().size() - 1);

		UserCardPile.getChildren().add(pass);

		txtField.setText("Computer Taken a Card");

		uno.setCurrentPlayer(uno.getComputer());
	}

	void computerTakeCardFromPile() {

		if (counter == 5) {

			if (uno.getCurrentCard().getCardName().contains("ONE_PLUS"))
				uno.setStepNumber(1);
			if (uno.getStepNumber() == 0) {
				if (uno.getCurrentCard().getCardName().contains("TWO_PLUS")) {
					uno.setStepNumber(1);
					uno.getComputer().draw(uno.getUnoDeck().getDrawPile().pop());

					ImageView computerC = (ImageView) drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
					ComputerCardPile.getChildren().add(computerC);
				}
			}
		}

		ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().peek().getCardBackSidePhoto());
		drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
		uno.getComputer().draw(uno.getUnoDeck().getDrawPile().pop());
		ComputerCardPile.getChildren().add(temp);
		txtField.setText("");

	}

	

	void humanDiscard(int n) {
		uno.getUnoDeck().getDiscardPile().push(uno.getUser().discard(uno.getUser().getCards().get(n)));
		discardPile.getChildren().add(UserCardPile.getChildren().remove(n));
	}

	@FXML
	void discard(MouseEvent event) {
		if (wildCard == false) {
			ArrayList<ImageView> arr = new ArrayList<ImageView>();
			for (int i = 0; i < UserCardPile.getChildren().size(); i++) {
				arr.add((ImageView) UserCardPile.getChildren().get(i));
			}
			for (int i = 0; i < UserCardPile.getChildren().size(); i++) {
				arr.get(i).setOnMouseClicked(this::handle);

			}
		}
	}

	public void handle(MouseEvent event) {
                
		if (counter >= 4 && uno.getCurrentPlayer() == uno.getUser()) {
			if (UserCardPile.getChildren().get(0) == event.getTarget())
				index = 0;
			else if (UserCardPile.getChildren().get(1) == event.getTarget())
				index = 1;
			else if (UserCardPile.getChildren().get(2) == event.getTarget())
				index = 2;
			else if (UserCardPile.getChildren().get(3) == event.getTarget())
				index = 3;
			else if (UserCardPile.getChildren().get(4) == event.getTarget())
				index = 4;
			else if (UserCardPile.getChildren().get(5) == event.getTarget())
				index = 5;
			else if (UserCardPile.getChildren().get(6) == event.getTarget())
				index = 6;
			else if (UserCardPile.getChildren().get(7) == event.getTarget())
				index = 7;
			else if (UserCardPile.getChildren().get(8) == event.getTarget())
				index = 8;
			else if (UserCardPile.getChildren().get(9) == event.getTarget())
				index = 9;
			else if (UserCardPile.getChildren().get(10) == event.getTarget())
				index = 10;
			else if (UserCardPile.getChildren().get(11) == event.getTarget())
				index = 11;
			else if (UserCardPile.getChildren().get(12) == event.getTarget())
				index = 12;

			if (uno.getUser().getCards().size() == 2) {

				if (unoCounter == 0) {
					txtField.setText("You have not said UNO");

					userTakeCard();

					uno.setCurrentPlayer(uno.getComputer());

				}
				if (unoCounter != 0)
					unoCounter = 0;
			}

			if (uno.getUser().getCards().get(index).getCardName().equals("WILD_MONSTER")) {
				txtField.setText("Wild card Thrown! Select  a color Now");

				humanDiscard(index);
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());

				if (uno.getCurrentPlayer().getCards().size() == 0) {
					txtField.setText("Congratulations! You won!");
					startButton.setText("Player Won");
				}
				wildCard = true;

				return;

			}
			if (uno.checkWildCard(uno.getUser().getCards().get(index))) {
				uno.getUnoDeck().getDiscardPile().push(uno.getUser().getCards().get(index));
				humanDiscard(index);
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				if (uno.getCurrentPlayer().getCards().size() == 0) {
					txtField.setText("Congratulations! You won!");
					startButton.setText("Player Won");
				}
                                
				uno.setCurrentPlayer(uno.getComputer());
				return;
			} else
				return;
		}
                
	}

	void computerDiscard(int i) {

		if (uno.checkWildCard(uno.getComputer().getCards().get(i))) {

			ImageView temp = new ImageView(uno.getComputer().getCards().get(i).getCardPicture());
			uno.getUnoDeck().getDiscardPile().push(uno.getComputer().getCards().remove(i));
			ComputerCardPile.getChildren().remove(i);

			discardPile.getChildren().add(temp);
			return;
		}

	}

	@FXML
	void drawClicked() {

		if (wildCard == false) {
			if (uno.getCurrentPlayer() == uno.getUser() && uno.getStepNumber() == 0) {

				if (uno.getCurrentCard().getCardName().contains("ONE_PLUS"))
					uno.setStepNumber(1);

				if (uno.getCurrentCard().getCardName().contains("TWO_PLUS")) {
					uno.setStepNumber(1);
					userTakeCard();
				}
				userTakeCard();

				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				uno.setCurrentPlayer(uno.getComputer());
			} else

			{
				userTakeCard();
				uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());
				uno.setCurrentPlayer(uno.getComputer());

				return;

			}
		}

	}

        
	/**
         * distribute 5 card to both the players
         */       
	void distributeCards() {

                int index=0;
		while (index < 5) {

			userTakeCard();
			computerTakeCardFromPile();
			txtField.setText("Cards are given to players");
			if (uno.getComputer().isFirstPlayer()) {
				
				uno.setCurrentPlayer(uno.getComputer());

			} else {
				
				uno.setCurrentPlayer(uno.getUser());
			}
                        index++;

		}
	}

        //when start button is clicked
	@FXML
	void startButtonClicked() {
		if (uno.getComputer().getCards().size() == 2) {
			computerTakeCardFromPile();

		}

		if (counter == 5 && uno.getCurrentPlayer().getCards().size() == 2) {
			txtField.setText("UNO!");
			unoCounter++;

		}

		if (counter == 0) {

			for (int i = 0; i < uno.getUnoDeck().getDrawPile().size(); i++) {
				ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().get(i).getCardPicture());

				drawPile.getChildren().add(temp);

			}

			txtField.setText("Press Start again");
			shuffle();

			counter++;

		} else if (counter == 1) {
			do{
			computerTakeCardFromPile();
			userTakeCard();
			clearDeck();
			
			}while(uno.getComputer().getCards().get(0).getCardValue()==0||uno.getUser().getCards().get(0).getCardValue()==0);
			ImageView temp1 = new ImageView(uno.getComputer().getCards().get(0).getCardPicture());
			ComputerCardPile.getChildren().set(0, temp1);
			ImageView temp = new ImageView(uno.getUser().getCards().get(0).getCardPicture());
			UserCardPile.getChildren().set(0, temp);
			if (uno.getComputer().getCards().get(0).getCardValue() > uno.getUser().getCards().get(0).getCardValue()) {
				uno.getComputer().setFirstPlayer(true);

			} else {
				uno.getUser().setFirstPlayer(true);
			}

			if (uno.getUser().isFirstPlayer() == true)
				txtField.setText("User's card is bigger.  User starts first!");
			else
				txtField.setText("Computer's card is bigger.  Computer starts first!");
			counter++;

		} else if (counter == 2) {
			uno.getUser().discard(uno.getUser().getCards().get(0));

			uno.getComputer().discard(uno.getComputer().getCards().get(0));

			shuffle();

			distributeCards();
			
			counter++;
		} else if (counter == 3) {
			while (true) {
				Card top = uno.getUnoDeck().getDrawPile().peek();
				top.setCardFaceDown(false);
				if ((top.getCardValue()) == 0) {
					ImageView temp = new ImageView(uno.getUnoDeck().getDrawPile().peek().getCardPicture());
					uno.getUnoDeck().getDiscardPile().add(uno.getUnoDeck().getDrawPile().pop());
					drawPile.getChildren().remove(drawPile.getChildren().size() - 1);
					discardPile.getChildren().add(temp);
					txtField.setText("Not a number card, so click start button again");

					return;
				} else {
					Card tempCard = uno.getUnoDeck().getDrawPile().pop();
					ImageView temp = new ImageView(tempCard.getCardPicture());
					uno.getUnoDeck().getDiscardPile().add(tempCard);
					drawPile.getChildren().remove(drawPile.getChildren().size() - 1);

					discardPile.getChildren().add(temp);

					break;
				}

			}

			uno.setCurrentCard(uno.getUnoDeck().getDiscardPile().peek());// currentCard

			String name = "";
			if (uno.getCurrentPlayer() == uno.getComputer()) {
				name = " Computer";

				txtField.setText("Game has started. Computer starts first! press start again");
				counter++;
			} else {
				name = " Jasmeen ";
				txtField.setText("Now Game has started. First Player is " + name);
				counter++;
			}
		}

		else if (counter == 4) {
			if (uno.getCurrentPlayer() == uno.getComputer()) {
				computerTakeTurn();
				uno.setCurrentPlayer(uno.getUser());
			} else if (counter == 4 && uno.getCurrentPlayer() == uno.getUser()) {
				txtField.setText("Press one more to start");

			}
			counter++;

		} else if (counter == 5
				&& (uno.getUser().getCards().size() != 0 || uno.getComputer().getCards().size() != 0)) {

			txtField.setText("Game Started");
			startButton.setText("UNO");

			if (uno.getUnoDeck().getDrawPile().size() <= 2) {
				txtField.setText("Press UNO to restart");

				shuffleDeck();

			}

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
