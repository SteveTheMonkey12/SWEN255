import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


/**
 * The Class CharacterSelection to allow people to choose their characters.
 */
public class CharacterSelection extends JFrame implements ActionListener {
	
	/** The character options */
	private JRadioButton lucilla, bert, maline, percy;
	
	/** The confirm button to choose character. */
	private JButton confirm;
	
	/** The number of players (3-4). */
	private int players; // 
	
	/** The count to keep track of number of times a character has been chosen. */
	private int count = 0;
	
	/** The characters chosen. */
	private ArrayList<String> characters = new ArrayList<String>();
	
	/** frame opened/closed. */
	private boolean closed = false;
	
	/** The game. */
	private Game game;

	/**
	 * Instantiates a new character selection.
	 *
	 * @param game the game
	 * @param players the players
	 */
	public CharacterSelection(Game game, int players) {
		this.players = players;
		this.game = game;
		// Lucilla
		lucilla = new JRadioButton("Lucilla");
		lucilla.setBounds(100, 10, 100, 30);
		this.add(lucilla);
		// Bert
		bert = new JRadioButton("Bert");
		bert.setBounds(100, 40, 100, 30);
		this.add(bert);
		// Maline
		maline = new JRadioButton("Maline");
		maline.setBounds(100, 70, 100, 30);
		this.add(maline);
		// Percy
		percy = new JRadioButton("Percy");
		percy.setBounds(100, 100, 100, 30);
		this.add(percy);

		// Confirm button
		confirm = new JButton("Confirm");
		confirm.setBounds(100, 150, 100, 30);
		confirm.addActionListener(this);
		this.add(confirm);

		// set up frame
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Select a player to play as and prompt next player.
	 *
	 * @param e the action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (lucilla.isSelected()) {
			count++;
			JOptionPane.showMessageDialog(this, "Your character is: Lucilla \nNext player please choose");
			lucilla.setSelected(false);
			lucilla.setEnabled(false);
			characters.add("Lucilla");
			closeFrame();
		} else if (bert.isSelected()) {
			count++;
			JOptionPane.showMessageDialog(this, "Your character is: Bert \nNext player please choose");
			bert.setSelected(false);
			bert.setEnabled(false);
			characters.add("Bert");
			closeFrame();
		} else if (maline.isSelected()) {
			count++;
			JOptionPane.showMessageDialog(this, "Your character is: Maline \nNext player please choose");
			maline.setSelected(false);
			maline.setEnabled(false);
			characters.add("Maline");
			closeFrame();
		} else if (percy.isSelected()) {
			count++;
			JOptionPane.showMessageDialog(this, "Your character is: Percy \nNext player please choose");
			percy.setSelected(false);
			percy.setEnabled(false);
			characters.add("Percy");
			closeFrame();
		} else {
			JOptionPane.showMessageDialog(this, "Please select a character");
		}
	}

	/**
	 * Gets the characters.
	 *
	 * @return the characters
	 */
	public ArrayList<String> getCharacters() {
		return this.characters;
	}

  /**
   * Checks if all players have chosen their character and closes frame if true
   * 
   * @return returns boolean if frame has been closed or not
   */
	
	public boolean closeFrame() {
		if (count == players) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			dispose();
			game.updateCharactersPlaying(characters);
			closed = true;
		}
		return closed;
	}

}
