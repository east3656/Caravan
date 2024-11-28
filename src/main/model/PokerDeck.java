package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PokerDeck implements Deck {
    private final List<Card> cards = new ArrayList<>();
    private final int maxSize; //this is the MAX LIMIT SIZE OF A DECK. NOT THE ACTUAL SIZE OF THE DECK


    public PokerDeck(){
        maxSize = 52;
        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                cards.add(new PokerCard(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public PokerDeck(int n){
        assert n>0;
        maxSize = n;

    }

    public int getMaxSize(){
        return maxSize;
    }

    public int getSize(){
        return cards.size();
    }


    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards); // deep copy MIGHT NEED TO REMOVE LATER
    }

    @Override
    public boolean addCard(Card card) {

        if (maxSize < this.getSize()+1){
            return false;
        }

        cards.add(card);
        return true;//INCOMPLETE
    }

    @Override
    public Card removeCard() {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = cards.size() - 1; i >= 0; i--) { // IMPORTANT: WE ARE DISPLAYING FROM LAST CARD EVER INSERTED, SO LAST IN THE ARRAYLIST TO FIRST TO RESPECT A TOP FIRST BOTTOM UP APPROACH
            sb.append(cards.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
