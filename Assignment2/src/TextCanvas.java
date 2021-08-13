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

	private String player;
	private int steps;
	private List<Item> cards;
	private Game game;

	/**
	 * Construct a canvas to visually display a given board.
	 *
	 * @param board
	 */
	public TextCanvas(Game game) {
		setBounds(0, 960, 400, 960);
		this.game = game;
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
		g.drawString("use w/W as up", 10, 200);
		g.drawString("use a/A as left", 10, 220);
		g.drawString("use s/S as right", 10, 240);
		g.drawString("use s/S as down", 10, 260);
		if(game.isPlaying() == true) {
			// show the name of the player
			g.drawString(player + "'s turn", 10, 20);
			//show the image of the player
			try {
				BufferedImage bi = ImageIO.read(new File("./images/"+player + ".png"));
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

}
