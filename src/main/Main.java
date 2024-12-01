package main;


import main.controller.CaravanController;
import main.model.*;
import main.view.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Deck> playerDecks = List.of(new PokerDeck(true), new PokerDeck(true), new PokerDeck(true));
        List<Deck> opponentDecks = List.of(new PokerDeck(true), new PokerDeck(true), new PokerDeck(true));



        // Create displays
        CompositeDisplay playerDisplay = new CompositeDisplay(playerDecks, "Player");
        CompositeDisplay opponentDisplay = new CompositeDisplay(opponentDecks, "Opponent");

        // Create controller
        CaravanController controller = new CaravanController(model, playerDisplay, opponentDisplay);

        // Start the game
        controller.startGame();
    }
}
