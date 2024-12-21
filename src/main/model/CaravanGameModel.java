package main.model;


import main.view.CompositeCards;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class CaravanGameModel implements GameModel {
  private final Deck playerHand;
  private final Deck opponentHand;
  private final CompositeCards playerPiles;
  private final CompositeCards opponentPiles;
  private Card currentCard;

  public CaravanGameModel() {
    //initialize hands of opponents and the decks.
      playerHand = new PokerDeck(5);
      opponentHand = new PokerDeck(5);

      playerPiles = new CompositeCards(List.of(new PokerDeck(true), new PokerDeck(true), new PokerDeck(true)), "Player");
      opponentPiles = new CompositeCards(List.of(new PokerDeck(true), new PokerDeck(true), new PokerDeck(true)), "Opponent");

  }

  public int parseInput(boolean deck){
      /*Return code is key here:
      * if we return 0, then we
      * confirm that we
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

          playerHand.addCard(new PokerCard());

          return 1;
      }else if ((is("1",m) || is("2",m) || is("3",m) || is("4",m) || is("5",m)) && !deck){

          System.out.println("You chose " + (playerHand.getCards().get(parseInt(m))).toString() + ".");
          currentCard = playerHand.removeCard(parseInt(m));
          return 0;
      }else if((is("1",m) || is("2",m) || is("3",m)) && deck){
          assert currentCard!=null;

          System.out.println("You put the " + currentCard + " into the " + getDeckNum(parseInt(m)) + " deck ");

          playCard(currentCard, Integer.parseInt(m));

          currentCard = null;


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

    @Override
    public void startGame(){
        System.out.println("You are currently playing Console text-based Caravan.");

        while (true) {

            displayPlayerHand();
            playerPiles.render();
            opponentPiles.render();
            System.out.println("For help on controls, input h or help");

            System.out.println("Your turn: select a card to draw from your hand, or choose to draw/discard. ");
            int a = parseInput(false);

            if (a == -1)break;
            else if (a == 0) {
                System.out.println("Select the deck number you'd like to add your Card to: (1-3)");
                int b = parseInput(true );
                if ( b == -1)break;
            }

            if (isGameOver()){
                if(playerPiles.isWinning()){
                    System.out.println("You won!");
                }else {
                    System.out.println("Another win for the Texas Ranger.");
                }
                break;
            }

        }
    }

  public String getDeckNum(int m){
      String i;
      if (m==1){i="left";}else if (m==2){i="middle";}else{i="right";}
      return i;
  }

  public void playCard(Card c, int m) {
      playerPiles.addCard(c,m-1);
  }


  public void playCardOpp(){
    // implement 
  }

  private static String helpCenter(){
        return ("To play any card in your hand, you must input the correct number \n" +
                "from 1 to 5 associated with it. If permissible and you wish to \n " +
                "draw a card, select d. If you wish to discard a card from\n your hand, select f." +
                "To quit, input q or quit.");

  }

  public void displayPlayerHand(){
        System.out.println("Your hand: " + playerHand.displayAsHand());
  }

  public static boolean is(String a, String b){
        return a.equalsIgnoreCase(b);
    }

    @Override
    public boolean isGameOver(){
      return playerPiles.isWinning() | opponentPiles.isWinning();
    }

 
}
