package model;

public interface Card {
    Rank getRank();
    Suit getSuit();
    String display(); // e.g., "Ace of Hearts"
    int getRankValue();
}
