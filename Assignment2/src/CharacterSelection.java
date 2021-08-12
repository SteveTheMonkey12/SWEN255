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

public class CharacterSelection extends JFrame implements ActionListener {
	private JRadioButton lucilla, bert, maline, percy; // character options
	private JButton confirm; // confirm button to choose character
	private int players; // number of players (3-4)
	private int count = 0; // keep track of number of times a character has been chosen
	private ArrayList<String> characters = new ArrayList<String>();// chosen characters
	private boolean closed = false; // frame opened/closed
	private Game game;

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

	public ArrayList<String> getCharacters() {
		return this.characters;
	}

  /*
  *Checks if all players have choosen their character and closes frame if true
  *@return returns boolean if frame has been closed or not
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
