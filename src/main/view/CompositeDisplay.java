package main.view;

import java.util.ArrayList;
import java.util.List;

import main.model.*;

public class CompositeDisplay {
    private final List<Deck> decks;
    private final String owner; // "enemy" or "player"

    public CompositeDisplay(List<Deck> decks, String owner) {
        this.decks = decks;
        this.owner = owner;

        // Register as a listener to each deck
        for (Deck deck : decks) {
            deck.addListener(this::render);
        }
    }

    public void render() {
        System.out.println(owner + "'s decks to pile up:");

        int maxHeight = decks.stream()
                .mapToInt(deck -> deck.getCards().size())
                .max()
                .orElse(0);

        List<List<String>> deckDisplays = new ArrayList<>();
        for (Deck deck : decks) {
            List<Card> cards = deck.getCards();
            List<String> cardStrings = new ArrayList<>();
            for (Card card : cards) {
                cardStrings.add(card.toString());
            }
            while (cardStrings.size() < maxHeight) {
                cardStrings.add("*empty*");
            }
            deckDisplays.add(cardStrings);
        }

        for (int row = maxHeight - 1; row >= 0; row--) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int col = 0; col < decks.size(); col++) {
                rowBuilder.append(String.format("%-20s", deckDisplays.get(col).get(row)));
            }
            System.out.println(rowBuilder.toString().stripTrailing());
        }

        StringBuilder labelBuilder = new StringBuilder();
        for (int i = 1; i <= decks.size(); i++) {
            labelBuilder.append(String.format("deck %-15d", i));
        }
        System.out.println(labelBuilder.toString().stripTrailing());
    }
}

