package main;


import main.controller.CaravanController;
import main.model.*;
import main.view.*;

public class Main {
    public static void main(String[] args) {
        // Create game model
        GameModel model = new CaravanGameModel();

        // Create displays
        CompositeDisplay playerDisplay = new CompositeDisplay(/*playerDecks, "player"*/);
        CompositeDisplay opponentDisplay = new CompositeDisplay(/*opponentDecks, "opponent"*/);

        // Create controller
        CaravanController controller = new CaravanController(model, playerDisplay, opponentDisplay);

        // Start the game
        controller.startGame();
    }
}
