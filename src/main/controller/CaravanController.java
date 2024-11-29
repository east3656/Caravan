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

            int n = game.parseInput(scanner.nextLine().toLowerCase());
            if (n == -1) {
                break;
            }

        }
        scanner.close();

    }
}
