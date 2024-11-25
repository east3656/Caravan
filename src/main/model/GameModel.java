public interface GameModel {
    void initializeGame();
    boolean isGameOver();
    void playTurn(Player player);
    void endGame();
    GameState getGameState();
}
