import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * <p>
 * Implements the board area in which the game are played. This is implement as
 * an extension of java.awt.Canvas, and characters, weapons and estates are
 * drawn directly onto this as images. The background is constructed by drawing
 * a sequence of filled squares.
 * </p>
 * 
 * @author pengailin refer the code from SWEN221 assignments
 */
public class BoardCanvas extends Canvas {
	/**
	 * The square width constant determines the width (in pixels) of a square in the
	 * board area.
	 */
	private static final int SQUARE_WIDTH = 40;

	/**
	 * The square height constant determines the height (in pixels) of a square in
	 * the battle area.
	 */
	private static final int SQUARE_HEIGHT = 40;

	private Board board;
	private Game game;
	private boolean playing = false;

	/**
	 * Construct a canvas to visually display a given board.
	 *
	 * @param board
	 */
	public BoardCanvas(Game game) {
		this.game = game;
		setBounds(0, 0, 24 * SQUARE_WIDTH, 24 * SQUARE_HEIGHT);

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

		// Draw estate, walls, and doors
		g2d.setStroke(new BasicStroke(4));
		// Haunted house
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawRect(2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.drawLine(7 * SQUARE_WIDTH, 3 * SQUARE_HEIGHT, 7 * SQUARE_WIDTH, 4 * SQUARE_HEIGHT);// right door
		g2d.drawLine(5 * SQUARE_WIDTH, 7 * SQUARE_HEIGHT, 6 * SQUARE_WIDTH, 7 * SQUARE_HEIGHT);// bottom door

		// Manic manor
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawRect(17 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(17 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.drawLine(20 * SQUARE_WIDTH, 7 * SQUARE_HEIGHT, 21 * SQUARE_WIDTH, 7 * SQUARE_HEIGHT);// bottom door
		g2d.drawLine(17 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT, 17 * SQUARE_WIDTH, 6 * SQUARE_HEIGHT);// left door

		// Villa Celia
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawRect(9 * SQUARE_WIDTH, 10 * SQUARE_HEIGHT, 6 * SQUARE_WIDTH, 4 * SQUARE_HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(9 * SQUARE_WIDTH, 10 * SQUARE_HEIGHT, 6 * SQUARE_WIDTH, 4 * SQUARE_HEIGHT);
		g2d.drawLine(12 * SQUARE_WIDTH, 10 * SQUARE_HEIGHT, 13 * SQUARE_WIDTH, 10 * SQUARE_HEIGHT);// top door
		g2d.drawLine(15 * SQUARE_WIDTH, 11 * SQUARE_HEIGHT, 15 * SQUARE_WIDTH, 12 * SQUARE_HEIGHT);// right door
		g2d.drawLine(11 * SQUARE_WIDTH, 14 * SQUARE_HEIGHT, 12 * SQUARE_WIDTH, 14 * SQUARE_HEIGHT);// bottom door
		g2d.drawLine(9 * SQUARE_WIDTH, 13 * SQUARE_HEIGHT, 9 * SQUARE_WIDTH, 12 * SQUARE_HEIGHT);// left door

		// Calamity Castle
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawRect(2 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(2 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.drawLine(3 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 4 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT);// top door
		g2d.drawLine(7 * SQUARE_WIDTH, 18 * SQUARE_HEIGHT, 7 * SQUARE_WIDTH, 19 * SQUARE_HEIGHT);// right door

		// Peril Palace
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawRect(17 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(17 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 5 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT);
		g2d.drawLine(18 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 19 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT);// top door
		g2d.drawLine(17 * SQUARE_WIDTH, 20 * SQUARE_HEIGHT, 17 * SQUARE_WIDTH, 21 * SQUARE_HEIGHT);// left door

		// Write Names
		g2d.setColor(new Color(100, 149, 237));
		g2d.drawString("Haunted House", 3 * SQUARE_WIDTH, 4 * SQUARE_HEIGHT);
		g2d.drawString("Manic Manor", 18 * SQUARE_WIDTH, 4 * SQUARE_HEIGHT);
		g2d.drawString("Villa Celia", 11 * SQUARE_WIDTH, 12 * SQUARE_HEIGHT);
		g2d.drawString("Calamity Castle", 3 * SQUARE_WIDTH, 20 * SQUARE_HEIGHT);
		g2d.drawString("Peril Palace", 18 * SQUARE_WIDTH, 20 * SQUARE_HEIGHT);

		// Draw the blocks
		g2d.setColor(Color.GRAY);
		g2d.fillRect(11 * SQUARE_WIDTH, 5 * SQUARE_HEIGHT, 2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT);// top
		g2d.fillRect(17 * SQUARE_WIDTH, 11 * SQUARE_HEIGHT, 2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT);// right
		g2d.fillRect(11 * SQUARE_WIDTH, 17 * SQUARE_HEIGHT, 2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT);// bottom
		g2d.fillRect(5 * SQUARE_WIDTH, 11 * SQUARE_HEIGHT, 2 * SQUARE_WIDTH, 2 * SQUARE_HEIGHT);// left

		// draw characters and weapons
		if (playing == true) {
			drawPlayer(g, width, height);
			drawWeapon(g);
		}

	}

	public void drawPlayer(Graphics g, int width, int height) {
		if (game.numPlayers == 4) {
			for (int i = 0; i < game.numPlayers; i++) {
				Player p = game.getPlayers().get(i);
				g.setColor(randomColor());
				g.drawOval(p.getPosition().getX() * SQUARE_WIDTH, p.getPosition().getY() * SQUARE_HEIGHT, width,
						height);
			}
		} else {
			for (int i = -0; i < game.numPlayers; i++) {
				Player p = game.getPlayers().get(i);
				g.setColor(randomColor());
				g.drawOval(p.getPosition().getX() * SQUARE_WIDTH, p.getPosition().getY() * SQUARE_HEIGHT, width,
						height);
			}
			Player p = game.getPlayers().get(3);
			g.setColor(randomColor());
			g.drawOval(19 * SQUARE_WIDTH, 23 * SQUARE_HEIGHT, width, height);
		}

	}

	public Color randomColor() {
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r, g, b);
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void drawWeapon(Graphics g) {
		for (int i = 0; i < game.getWeapons().size(); i++) {
			Weapon w = game.getWeapons().get(i);
			String name = w.getName();
			g.drawString(name, w.getPosition().getX() * SQUARE_WIDTH, w.getPosition().getY() * SQUARE_HEIGHT);
		}
	}

}
