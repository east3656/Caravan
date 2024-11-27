package model;

public interface GameModel {
    void startGame();

    //Actions
    void playCard();
    void playCardOpp();

    

    
    boolean isGameOver();
    void playTurn(Player player);
    void endGame();
    GameState getGameState();
}
