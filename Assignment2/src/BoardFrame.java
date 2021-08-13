import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 * Implements the outer window of the Murder Madness game. This includes any
 * buttons, the window frame itself.
 *
 * @author pengailin refer the code from SWEN221 assignments
 */
public class BoardFrame extends JFrame implements ActionListener{
	
	// Jpanel
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;

	// canvas
	private static BoardCanvas boardCanvas;
	private static TextCanvas textCanvas;

	// menu part:
	private JMenu menu;
	private JMenuItem exit;
	private JMenuBar mb;

	public int turns;	// Number on last dice roll
	private Board board;
	private Game game;

	public BoardFrame(Game game) {

		this.game = game;

		// menu bar
		mb = new JMenuBar();
		menu = new JMenu("Murder Madness");
		exit = new JMenuItem("Exit");
		menu.add(exit);
		Map<String, JMenuItem> menuItem = new HashMap<>();
		menuItem.put("Exit", exit);
		exit.addActionListener(this);// Confirm exit
		mb.add(menu);
		setJMenuBar(mb);

		// center board canvas
		this.boardCanvas = new BoardCanvas(game);
		this.centerPanel = new JPanel();
		this.centerPanel.setLayout(new BorderLayout());
		Border cb = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3),
				BorderFactory.createLineBorder(Color.gray));
		this.centerPanel.setBorder(cb);
		this.centerPanel.add(boardCanvas, BorderLayout.CENTER);

		// button on the bottom
		JButton start = new JButton("Start Game");
		JButton stop = new JButton("Stop Game");
		JButton guess = new JButton("Guess");

		// right text canvas
		this.textCanvas = new TextCanvas(game);
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new BorderLayout());
		cb = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3),
				BorderFactory.createLineBorder(Color.white));
		rightPanel.setBorder(cb);
		this.rightPanel.setBorder(cb);
		this.rightPanel.add(textCanvas, BorderLayout.EAST);

		// button action listener
		start.addActionListener(this);
		stop.addActionListener(this);
		guess.addActionListener(this);

		// add button at the bottom
		this.bottomPanel = new JPanel();
		this.bottomPanel.add(start);
		this.bottomPanel.add(stop);
		this.bottomPanel.add(guess);

		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		add(rightPanel, BorderLayout.EAST);

		setFocusable(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	public void stopGame() {
		for (Frame frame : getFrames()) {
			frame.dispose();
		}
		new BoardFrame(game);
	}

	@Override
	/*
	 * Connect the buttons with functions Confirmation pop-up when exit button is
	 * pressed
	 */
	public void actionPerformed(ActionEvent e) {
		if(game.isPlaying() == false) {
			if (e.getActionCommand().equals("Start Game")) {
				// optional for the number of players
				String[] options = { "3", "4" };
				int num = JOptionPane.showOptionDialog(null, "Number of Players", "Number of Players",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				game.setNumPlayers(num + 3);
				//choose characters
				CharacterSelection cs = new CharacterSelection(game, num+3);
				cs.setTitle("Select your character");
				cs.addWindowListener(new WindowAdapter() {
				    @Override
				    public void windowClosed(WindowEvent e) {//when characters have been selected, initialise game
				    game.initial();
					game.setPlaying(true);
					turns = game.diceResult();
					setTextCanvas(game.getCurrentPlayer(), turns, game.getCurrentPlayer().getItems());
					boardCanvas.repaint();
					textCanvas.repaint();
				    }
				});
			}
		} else if (e.getActionCommand().equals("Stop Game")) {
			if(game.isPlaying() == true) {
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the game?", "Stop game?",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					stopGame();
					game.setPlaying(false);
				}			
			}
		} else if (e.getActionCommand().equals("Guess")) {
			if(game.isPlaying() == true) {
				guess();
			}
		} else if (e.getActionCommand().equals("Solve Attempt")) {
			if(game.isPlaying() == true) {
				solveAttempt();
			}
		} else if (((JMenuItem) e.getSource()).getText().equals("Exit")) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				game.setPlaying(false);
				System.exit(0);
			}
		}
		boardCanvas.repaint();
		textCanvas.repaint();
	}
	
	private void solveAttempt() {
		int option = JOptionPane.showConfirmDialog(null, "Make solve attempt?", "Solve Attempt?",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.NO_OPTION) {
			return;
		}
		Player[] players = {null, null, null, null};
		String[] playerOptions = {"0", "0", "0", "0"};
		String[] weaponOptions = {"0", "0", "0", "0", "0"};
		Weapon[] weapons = {null, null, null, null, null};
		String[] estateOptions = {"0", "0", "0", "0", "0"};
		Estate[] estates = {null, null, null, null, null};
		for(int i = 0; i < 5; i++) {
			if(i < 4) {
				players[i] = game.getPlayer_Player(i);
				playerOptions[i] = players[i].getName();
			}
			weapons[i] = game.getWeapon_Weapon(i);
			weaponOptions[i] = weapons[i].getName();
			estates[i] = game.getEstate_Estate(i);
			estateOptions[i] = estates[i].getName();
		}
		int namedPlayer = JOptionPane.showOptionDialog(null, "Which character to accuse?", "Character Accusation",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, playerOptions, playerOptions[0]);
		Player guessedPlayer = players[namedPlayer];
		
		//weapon selection
		int namedWeapon = JOptionPane.showOptionDialog(null, "Which weapon to accuse?", "Weapon Accusation",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, weaponOptions, weaponOptions[0]);
		Weapon guessedWeapon = weapons[namedWeapon];
		int namedEstate = JOptionPane.showOptionDialog(null, "Which estate to accuse?", "Estate Accusation",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, estateOptions, estateOptions[0]);
		Estate guessedEstate = estates[namedEstate];		
		if(game.getMurderCards().contains(guessedPlayer) && game.getMurderCards().contains(guessedWeapon) && game.getMurderCards().contains(guessedEstate)) {
			//TODO win
			JOptionPane.showMessageDialog(null, "YOU WIN", "Win", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		else{
			//TODO lose
			JOptionPane.showMessageDialog(null, "YOU LOSE", "Lose", JOptionPane.PLAIN_MESSAGE);
		}
	}

	/*
	 * Extra UI for guess
	 */
	public void guess() {
		if(game.getCurrentPlayer().getEstate() == null) {
			JOptionPane.showMessageDialog(null, "You are not at an estate", "No Guess", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		//player selection
		Player[] players = {null, null, null, null};
		String[] playerOptions = {"0", "0", "0", "0"};
		String[] weaponOptions = {"0", "0", "0", "0", "0"};
		Weapon[] weapons = {null, null, null, null, null};
		for(int i = 0; i < 5; i++) {
			if(i < 4) {
				players[i] = game.getPlayer_Player(i);
				playerOptions[i] = players[i].getName();
			}
			weapons[i] = game.getWeapon_Weapon(i);
			weaponOptions[i] = weapons[i].getName();
		}
		int namedPlayer = JOptionPane.showOptionDialog(null, "Which character to accuse?", "Character Accusation",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, playerOptions, playerOptions[0]);
		Player guessedPlayer = players[namedPlayer];
		
		//weapon selection
		int namedWeapon = JOptionPane.showOptionDialog(null, "Which weapon to accuse?", "Weapon Accusation",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, weaponOptions, weaponOptions[0]);
		Weapon guessedWeapon = weapons[namedWeapon];
		Estate guessedEstate = game.getCurrentPlayer().getEstate();		
		Item response = null;
		game.getBoard().moveMoveableToEstate(guessedWeapon, guessedEstate);
		game.getBoard().moveMoveableToEstate(guessedPlayer, guessedEstate);
		Player respondingPlayer = game.getCurrentPlayer();
		for(int i = 0; i < game.getNumPlayers()-1; i++) {
			if(response == null) {
				respondingPlayer = game.getNextPlayer(respondingPlayer);
				response = respondToGuess(guessedPlayer, guessedWeapon, guessedEstate, respondingPlayer);
			}
		}
		JOptionPane.showMessageDialog(null, game.getCurrentPlayer().getName() + "'s turn");
		setTextCanvas(game.getCurrentPlayer(), 0, game.getCurrentPlayer().getItems());
		textCanvas.repaint();
		if(response == null) {
			JOptionPane.showMessageDialog(null, "No one had a response!!!", "Response", JOptionPane.PLAIN_MESSAGE);
			return;
		}textCanvas.repaint();
		JOptionPane.showMessageDialog(null, response.getName(), "Response", JOptionPane.PLAIN_MESSAGE);
		solveAttempt();
		return;
	}
	
	public Item respondToGuess(Player guessedPlayer, Weapon guessedWeapon, Estate guessedEstate, Player respondingPlayer) {
		JOptionPane.showMessageDialog(null, respondingPlayer.getName() + "'s response turn");
		setTextCanvas(respondingPlayer, 0, respondingPlayer.getItems());
		textCanvas.repaint();
		ArrayList<Item> respondableItems = new ArrayList<Item>();
		if(respondingPlayer.hasItem(guessedPlayer)) {
			respondableItems.add(guessedPlayer);
		}
		if(respondingPlayer.hasItem(guessedWeapon)) {
			respondableItems.add(guessedWeapon);
		}
		if(respondingPlayer.hasItem(guessedEstate)) {
			respondableItems.add(guessedEstate);
		}
		if(respondableItems.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No cards to respond with");
			return null;
		}
		String[] items = new String[respondableItems.size()];
		for(int i = 0; i < respondableItems.size(); i++) {
			items[i] = respondableItems.get(i).getName();
		}
		int responseItem = JOptionPane.showOptionDialog(null, "Which card to respond with?", "Player Response",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, items, items[0]);
		return respondableItems.get(responseItem);
	}
	
	/*
	 * Update text
	 */
	public void setTextCanvas(Player player, int steps, List<Item> cards) {
		textCanvas.setPlayer(player);
		textCanvas.setSteps(steps);
		textCanvas.setCards(cards);
	}

	/*
	 * Move player one space
	 * */
	public void takeTurn(Position pos) {
		int turnsUsed = game.getBoard().moveToClick(pos, game.getCurrentPlayer(), turns);
		if(turnsUsed != -1) {
			turns -= turnsUsed;
			textCanvas.setSteps(turns);
		}
      if(turns == 0){
			Player p = game.getNextPlayer(game.getCurrentPlayer());
			int dice = game.diceResult();
			turns = dice;
			turnsUsed = game.getBoard().moveToClick(pos, p, turns);
			setTextCanvas(p,turns,p.getItems());
			game.setCurrentPlayer(p);
		}
		boardCanvas.repaint();
		textCanvas.repaint();
	}

  	public static void main(String args[]) {
		Game game = new Game();
		BoardFrame bf = new BoardFrame(game);
		Controller controller = new Controller(game, bf, boardCanvas, textCanvas);
	}

}
