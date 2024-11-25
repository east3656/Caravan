package model;

import java.util.ArrayList;
import java.util.List;

public class CaravanGameModel implements GameModel {
  private final Deck playerHand = new SimpleDeck();
  private final Deck opponentHand = new SimpleDeck();

  
  public CaravanGameModel() {
       
  }

  @Override
  public void initializeGame() {
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


 
}
