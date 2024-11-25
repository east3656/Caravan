public class PokerCard implements Card{
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

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
    public String display(){

        return rank + " of " + suit;
    }

    @Override 
    public int getRankValue(){
        return rank.ordinal();
    }
    
    
    /*
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    
    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        System.out.println(card);
    }
*/
}
