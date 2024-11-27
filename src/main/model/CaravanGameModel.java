package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Deck;


public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;

    private final Deck playerHand = new PokerDeck(5);
    private final Deck opponentHand = new PokerDeck(5);

    //initialize decks to draw from.
    private final Deck playerDeck = new PokerDeck();
    private final Deck opponentDeck = new PokerDeck();


  private static String helpCenter(){
      return ("To play any card in your hand, you must input the correct number \n" +
      "from 1 to 5 associated with it. If permissible and you wish to draw a card, \n" +
              "press D key.");

  }

  
  public CaravanGameModel() {

    //initialize hands of opponents
    private final Deck playerHand = new PokerDeck(5);
    private final Deck opponentHand = new PokerDeck(5);

    //initialize decks to draw from. 
    private final Deck playerDeck = new PokerDeck();
    private final Deck opponentDeck = new PokerDeck();

    

    
       
  }

  public static boolean is(String a, String b){
      return a.equalsIgnoreCase(b);
  }

  @Override
  public void startGame() {
      Scanner scanner = new Scanner(System.in);


      CaravanGameModel game = new CaravanGameModel();
      System.out.println("For help on controls, input h or help");
      while (true) {
          String userInput = scanner.nextLine().toLowerCase().trim();
          if (is("quit", userInput) || is("q", userInput)) {
              break;

          }
          if(is("help", userInput) || is("h", userInput)){
              System.out.println(helpCenter());
          }
          else{

              move(userInput);
              //complete code with enemy movement, etc.


          }
      }

      scanner.close();
    }


    public static void move(String m){

      if (m.is("d")){
          //draw card code
      }else if (m.is("1") || m.is("2") || m.is("3") || m.is("4") || m.is("5")){

          playCard(parseInt(m));
      }else {
          System.out.println("Invalid input. Try again");
      }
    }

  
  @Override
  public void playCard() {
      // implement move.
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
