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

        for (int i = 0; i < n; i++) {
            cards.add(new PokerCard());
        }

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
    public Card removeCard(int i) {
        Card c = cards.get(i);
        cards.remove(i);
        return c;
    }


    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String display(int i) {

        if(i>cards.size()){return "none";}
        else {
            return cards.get(i).toString();
        }

    } //DEPRECATED



    @Override
    public String displayAsHand() {

        if (isEmpty()){return "[EMPTY HAND]";}
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cards.size(); i++) {
            sb.append(i).append(".").append(cards.get(i).toString()).append(" | ");
        }
        return sb.toString();
    }

    @Override
    public int returnAllRankValue(){
        int e = 0;
        if (cards.isEmpty()){return e;}
        for (Card card: cards){
            e+=card.getRankValue();
        }
        return e;
    }




}
