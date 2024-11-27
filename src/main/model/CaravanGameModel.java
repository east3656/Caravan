package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;

  
  public CaravanGameModel() {

    //initialize hands of opponents
    private final Deck playerHand = new PokerDeck(5);
    private final Deck opponentHand = new PokerDeck(5);

    //initialize decks to draw from. 
    private final Deck playerDeck = new PokerDeck();
    private final Deck opponentDeck = new PokerDeck();

    

    
       
  }

  @Override
  public void startGame() {
        // implement
    }
  
  @Override
  public void playCard() {
      // implement
  }


  @Override 
  public void playCardOpp(){
    // implement 
  }

  @Override
  boolean isGameOver(){return false;}
  
  @Override
  void playTurn(Player player){}
  
  @Override
  void endGame(){}
  
  @Override
  GameState getGameState(){}

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String userInput = scanner.nextLine().toLowerCase().trim();
            if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("q")) {
                break;
            } else{
               //add
            }
        }
        
        scanner.close();
    }


 
}
