package model;

import java.util.List;

public interface Deck {
    List<Card> getCards();
    void addCard(Card card);
    Card removeTopCard(); //WATCH OUT FOR THIS ONE LATER ON
    boolean isEmpty();
    String display(); // top-down view of the stack
}
