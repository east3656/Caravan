package main.model;


import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;


  private static String helpCenter(){
      return ("To play any card in your hand, you must input the correct number \n" +
      "from 1 to 5 associated with it. If permissible and you wish to \n " +
              "draw a card, select D key.\n" +
              "To quit, input q or quit.");

  }

  
  public CaravanGameModel() {

    //initialize hands of opponents
      playerHand = new PokerDeck(5);
      opponentHand = new PokerDeck(5);

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

              game.move(userInput);
              //complete code with enemy movement, etc.


          }
      }

      scanner.close();
    }


    public void move(String m){

      if (is("d", m)){
          //draw card code
      }else if (is("1",m) || is("2",m) || is("3",m) || is("4",m) || is("5",m)){
          System.out.println("You chose " + (playerHand.getCards().get(parseInt(m) - 1)).toString() + ".");
          this.playCard(parseInt(m));
      }else {
          System.out.println("Invalid input. Try again");
      }
    }

  
  @Override
  public void playCard(int m) {
      // implement move.
  }


  @Override 
  public void playCardOpp(){
    // implement 
  }

//  @Override
//  boolean isGameOver(){return false;}
//
 
}
