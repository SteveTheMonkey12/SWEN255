import java.util.*;

// line 16 "model.ump"
// line 74 "model.ump"
public class Player{
	
	private String name;
	private Character character;
	private List<Card> cards;
	
	//------------------------
	// CONSTRUCTOR
	//------------------------
	public Player(String name, List<Card> cards, Character character) {
		this.name = name;
		this.cards = cards;
		this.character = character;		
	}

	public Character getCharacter() {
		return character;
	}
	
	public Card getCard(int index) {
	    Card aCard = cards.get(index);
	    return aCard;
	}

	public List<Card> getCards() {
	    List<Card> newCards = Collections.unmodifiableList(cards);
	    return newCards;
	}

	public String getName() {
		return name;
	}
	
}