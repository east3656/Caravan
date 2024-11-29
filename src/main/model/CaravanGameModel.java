package main.model;


import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;

  private Card currentCard;

  private static String helpCenter(){
      return ("To play any card in your hand, you must input the correct number \n" +
      "from 1 to 5 associated with it. If permissible and you wish to \n " +
              "draw a card, select D key.\n" +
              "To quit, input q or quit.");

  }

  public void displayPlayerHand(){
      System.out.println("Your hand: " + playerHand.displayAsHand());
  }

  
  public CaravanGameModel() {

    //initialize hands of opponents
      playerHand = new PokerDeck(5);
      opponentHand = new PokerDeck(5);

  }

  public static boolean is(String a, String b){
      return a.equalsIgnoreCase(b);
  }


  public int parseInput(String n, boolean deck){

      if (is("quit", n) || is("q", n)) {
          return -1;
      }
      if(is("help", n) || is("h", n)){
          System.out.println(helpCenter());
          return 0;
      }
      else{
          int pass;
          do {
              pass = this.parseMove(n, deck);
          }while(pass!=0);

          return 0;
      }
  }




    public int parseMove(String m, boolean deck){

      if (is("d", m)){
          if (playerHand.isFull()){
              System.out.println("Your deck is full! You can't draw anymore. Try another input");
              return 1;
          }
          //draw card code
          return 0;
      }else if ((is("1",m) || is("2",m) || is("3",m) || is("4",m) || is("5",m)) && !deck){
          System.out.println("You chose " + (playerHand.getCards().get(parseInt(m))).toString() + ".");
          this.playCard(parseInt(m));
          return 0;
      }else if((is("1",m) || is("2",m) || is("3",m)) && deck){
          assert currentCard!=null;

          return 0;

      }else if(is(m,"f")){

          if (playerHand.isEmpty()){
              System.out.println("Deck is empty! Move invalid.");
              return 1;
          }
          System.out.println("What card do you wish to DISCARD? (1-5 / Selected Card) ");
          Scanner scanner = new Scanner(System.in);
          while(true){
              int i = parseInt(scanner.nextLine());
              boolean isInRange = (1 <= i && i <= playerHand.getSize());
              if (isInRange){
                  playerHand.removeCard(i);
                  return 0;
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

  
  @Override
  public void playCard(int m) {
      currentCard = playerHand.removeCard(m);
  }


  @Override 
  public void playCardOpp(){
    // implement 
  }

//  @Override
//  boolean isGameOver(){return false;}
//
 
}
