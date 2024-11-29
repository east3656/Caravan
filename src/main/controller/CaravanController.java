package main.controller;

import main.model.*;
import main.view.*;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);


        CaravanGameModel game = new CaravanGameModel();


        System.out.println("You are currently playing Console text-based Caravan.");

        while (true) {

            game.displayPlayerHand();
            System.out.println("For help on controls, input h or help");

            System.out.println("Your turn: select a card to draw from your hand. ");
            int a = game.parseInput(scanner.nextLine().toLowerCase(), false);
            System.out.println("Select the deck number you'd like to apply it to: ");
            int b = game.parseInput(scanner.nextLine().toLowerCase(), true );
            if (a == -1 || b == -1) {
                break;
            }

        }
        scanner.close();

    }
}
