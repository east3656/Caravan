package main.model;

import java.util.List;

public interface Deck {
    List<Card> getCards();
    boolean addCard(Card card);
    Card removeCard(); //WATCH OUT FOR THIS ONE LATER ON
    boolean isEmpty();
    String display(int i);
    String displayAsHand();
    int returnAllRankValue();
}
