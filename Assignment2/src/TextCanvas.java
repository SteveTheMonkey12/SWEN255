import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;

/**
 * This canvas will show the cards for different player.
 * 
 * @author pengailin
 *
 */
public class TextCanvas extends Canvas {

	private String player;
	private int steps;
	private List<Item> cards;

	/**
	 * Construct a canvas to visually display a given board.
	 *
	 * @param board
	 */
	public TextCanvas() {
		setBounds(0, 960, 400, 960);
	}

	public void setPlayer(Player player) {
		this.player = player.getName();
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setCards(List<Item> cards) {
		this.cards = cards;
	}

	public void paint(Graphics g) {
		// show the name of the player
		g.drawString(player + "'s turn", 10, 20);
		// show the steps remaining
		g.drawString("You have " + steps + " left.", 10, 40);
		// show the cards on player's hand
		g.drawString("Cards in hand: ", 10, 60);
		int gap = 20;
		if (cards != null) {
			for (int i = 0; i < cards.size(); i++) {
				g.drawString(cards.get(i).getName(), 10, 60 + gap);
				gap+=20;
			}
		}
	}

}
