package model;

import java.util.ArrayList;
import java.util.List;

public class PokerDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards); // deep copy MIGHT NEED TO REMOVE LATER
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }


  
    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = cards.size() - 1; i >= 0; i--) { // IMPORTANT: WE ARE DISPLAYING FROM LAST CARD EVER INSERTED, SO LAST IN THE ARRAYLIST TO FIRST TO RESPECT A TOP FIRST BOTTOM UP APPROACH
            sb.append(cards.get(i).display()).append("\n");
        }
        return sb.toString();
    }
}
