import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * This canvas will show the cards for different player.
 * 
 * @author pengailin
 *
 */
public class TextCanvas extends Canvas {

	private Player player;
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
		this.player = player;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setCards(List<Item> cards) {
		this.cards = cards;
	}

	public void paint(Graphics g) {
		// show the name of the player
		String tmp = player.getName();
		g.drawString(player.getName() + "'s turn", 10, 20);
		//show the image of the player
		try {
			BufferedImage bi = ImageIO.read(new File("./Assignment2/images/"+player.getName() + ".png"));
			g.drawImage(bi, 10, 30, 34, 34, null);
		} catch (IOException e) {
			throw new Error("No images to draw player!");
		}
		// show the steps remaining
		g.drawString("You have " + steps + " left.", 10, 80);
		// show the cards on player's hand
		g.drawString("Cards in hand: ", 10, 100);
		int gap = 20;
		if (cards != null) {
			for (int i = 0; i < cards.size(); i++) {
				g.drawString(cards.get(i).getName(), 10, 100 + gap);
				gap+=20;
			}
		}
	}

}
