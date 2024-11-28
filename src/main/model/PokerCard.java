package main.model;



public class PokerCard implements Card{




    private final Rank rank;
    private final Suit suit;

    public PokerCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
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
