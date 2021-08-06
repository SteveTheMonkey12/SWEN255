import java.awt.Canvas;

/**
 * This canvas will show the cards for different player.
 * @author pengailin
 *
 */
public class TextCanvas extends Canvas {
	
	private String player;
	private String weapon;
	public Game game;
	
	/**
	 * Construct a canvas to visually display a given board.
	 *
	 * @param board
	 */
	public TextCanvas() {
		setBounds(0, 960, 400, 960);
	}

}
