package main.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;
  private final List<Deck> playerPiles;
  private final List<Deck> opponentPiles;
  private Card currentCard;

  private static String helpCenter(){
      return ("To play any card in your hand, you must input the correct number \n" +
      "from 1 to 5 associated with it. If permissible and you wish to \n " +
              "draw a card, select d. If you wish to discard a card from\n your hand, select f." +
              "To quit, input q or quit.");

  }

  public void displayPlayerHand(){
      System.out.println("Your hand: " + playerHand.displayAsHand());
  }

  
  public CaravanGameModel(List<Deck> playerDecks, List<Deck> opponentDecks) {

    //initialize hands of opponents
      playerHand = new PokerDeck(5);
      opponentHand = new PokerDeck(5);
      playerPiles = playerDecks;
      opponentPiles = opponentDecks;

  }

  public static boolean is(String a, String b){
      return a.equalsIgnoreCase(b);
  }


  public int parseInput(boolean deck){


      /*Return code is key here:
      * if we return 0, then we
      * confirm to the controller that we
      * will be putting a card in one of our decks.
      *
      * */
      Scanner scanner = new Scanner(System.in);
              String n = scanner.nextLine();
      if (is("quit", n) || is("q", n)) {
          return -1;
      }
      if(is("help", n) || is("h", n)){
          System.out.println(helpCenter());
          return 3;
      }

      else{
          int pass;
          do {
              pass = this.parseMove(n, deck);
              if (pass==-1 | pass==2){
                  n = scanner.nextLine();
              }
          }while(pass==2 | pass==-1);

          return pass;
      }
  }




    public int parseMove(String m, boolean deck){

      if (is("d", m)){
          if (playerHand.isFull()){
              System.out.println("Your deck is full! You can't draw anymore. Try another input");
              return -1;
          }
          //draw card code
          return 1;
      }else if ((is("1",m) || is("2",m) || is("3",m) || is("4",m) || is("5",m)) && !deck){

          System.out.println("You chose " + (playerHand.getCards().get(parseInt(m))).toString() + ".");
          currentCard = playerHand.removeCard(parseInt(m));
          return 0;
      }else if((is("1",m) || is("2",m) || is("3",m)) && deck){
          assert currentCard!=null;

          System.out.println("You put the " + currentCard + " into the " + getDeckNum(parseInt(m)) + " deck ");



          return 0;

      }else if(is(m,"f")){

          if (playerHand.isEmpty()){
              System.out.println("Deck is empty! Move invalid.");
              return -1;
          }
          System.out.println("What card do you wish to DISCARD? (1-5 / Selected Card) ");
          Scanner scanner = new Scanner(System.in);
          while(true){
              int i = parseInt(scanner.nextLine());
              boolean isInRange = (1 <= i && i <= playerHand.getSize());
              if (isInRange){
                  Card card = playerHand.removeCard(i);
                  System.out.println("You discarded " + card.toString());
                  return 1;
              }else {
                  System.out.println("Invalid input. Try again.");
              }
          }


      }
      else {
          System.out.println("Invalid input. Try again");
          return 2;
      }
    }

  public String getDeckNum(int m){
      String i;
      if (m==1){i="left";}else if (m==2){i="middle";}else{i="right";}
      return i;
  }
  @Override
  public void playCard(int m) {

  }


  @Override 
  public void playCardOpp(){
    // implement 
  }

//  @Override
//  boolean isGameOver(){return false;}
//
 
}
