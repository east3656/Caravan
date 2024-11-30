package main.model;

import java.util.List;

public interface Deck {
    List<Card> getCards();
    boolean addCard(Card card);
    boolean isEmpty();
    String display(int i);
    String displayAsHand();
    int returnAllRankValue();
    Card removeCard(int i);
    int getSize();
    boolean isFull();

    void addListener(Object render);
}
