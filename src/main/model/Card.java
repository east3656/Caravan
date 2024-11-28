package main.model;

public interface Card {
    Rank getRank();
    Suit getSuit();
    int getRankValue();
}
