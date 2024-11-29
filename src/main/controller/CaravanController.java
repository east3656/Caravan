package main.controller;

import main.model.*;
import main.view.*;



public class CaravanController {
    private final GameModel model;
    private final CompositeDisplay playerDisplay;
    private final CompositeDisplay opponentDisplay;

    public CaravanController(GameModel model, CompositeDisplay playerDisplay, CompositeDisplay opponentDisplay) {
        this.model = model;
        this.playerDisplay = playerDisplay;
        this.opponentDisplay = opponentDisplay;
    }

    public void startGame() {



        CaravanGameModel game = new CaravanGameModel();


        System.out.println("You are currently playing Console text-based Caravan.");

        while (true) {

            game.displayPlayerHand();
            System.out.println("For help on controls, input h or help");

            System.out.println("Your turn: select a card to draw from your hand, or choose to draw/discard. ");
            int a = game.parseInput(false);
            if (a == -1)break;
            else if (a == 0) {
                System.out.println("Select the deck number you'd like to add your Card to: ");
                int b = game.parseInput(true );
                if ( b == -1)break;
            }


        }


    }
}
