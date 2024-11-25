import model.Deck;

public class DeckDisplay implements Display{

  private final Deck deck;
  
    public DeckDisplay(Deck deck) {
        this.deck = deck;
    }

    @Override
    public String render() {
        return deck.display();
    }

}
