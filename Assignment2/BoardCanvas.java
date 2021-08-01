import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;

/**
 * <p>
 * Implements the board area in which the game are played. This is implement as an
 * extension of java.awt.Canvas, and characters, weapons and estates are drawn directly onto this as
 * images. The background is constructed by drawing a sequence of filled squares.
 * </p>
 * 
 * @author pengailin
 * refer the code from SWEN221 assignments
 */
public class BoardCanvas extends Canvas {
	/**
	 * The path for storing images
	 */
	//private static final String IMAGE_PATH = "images/";

	/**
	 * The square width constant determines the width (in pixels) of a square in
	 * the board area.
	 */
	private static final int SQUARE_WIDTH = 30;


	 /**
	 *  The square height constant determines the height (in pixels) of a square
	 * in the battle area.
	 */
	private static final int SQUARE_HEIGHT = 30;

	private Board board;

	/**
	 * Construct a canvas to visually display a given board.
	 *
	 * @param board
	 */
	public BoardCanvas() {
		setBounds(0, 0, 24 * SQUARE_WIDTH, 24
				* SQUARE_HEIGHT);

	}

	/**
	 * Paint the given board onto the given graphics object.
	 */
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int width = 24;
		int height = 24;

		// Draw the background of the display as a rectangle of all white.
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);

		// Draw alternating boxes of light gray to give a checker-board display,
		// making it easier to distinguish the individual squares of the board.
		g2d.setColor(Color.LIGHT_GRAY);
		for (int x = 0; x < width; x = x + 1) {
			for (int y = 0; y < width; y = y + 1) {
				if ((x + y) % 2 == 0) {
					int xp = x * SQUARE_WIDTH;
					int yp = y * SQUARE_HEIGHT;
					g2d.fillRect(xp, yp, SQUARE_WIDTH, SQUARE_HEIGHT);
				}
			}
		}


	}








}
