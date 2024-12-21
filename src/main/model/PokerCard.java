package main.model;


import java.util.Random;

public class PokerCard implements Card{

    private final Rank rank;
    private final Suit suit;

    public PokerCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public PokerCard(){ //Add random PokerCard
        Random random = new Random();
        this.rank = Rank.values()[random.nextInt(Rank.values().length)];
        this.suit = Suit.values()[random.nextInt(Suit.values().length)];
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override 
    public int getRankValue(){
        return rank.ordinal();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
