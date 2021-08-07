import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
 * buttons, the window frame itself and its title.
 *
 * @author pengailin refer the code from SWEN221 assignments
 */
public class BoardFrame extends JFrame implements ActionListener {
    //Jpanel
	private JPanel bottomPanel;
	private JPanel centerPanel;
	private JPanel rightPanel;

	// canvas
	private BoardCanvas boardCanvas;
	private TextCanvas textCanvas;

	private Board board;
	private Game game;

	// menu part:
	private JMenu menu;

	private JMenuItem exit;

	private JMenuBar mb;

	public BoardFrame(Game game) {

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
		
        //button on the bottom
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		JButton guess = new JButton("Guess");
		JButton solve = new JButton("Solve Attempt");

        //right text canvas
		this.textCanvas = new TextCanvas();
		this.rightPanel = new JPanel(); 
		this.rightPanel.setLayout(new BorderLayout()); 
		cb =BorderFactory.createCompoundBorder(BorderFactory .createEmptyBorder(3, 3, 3,
		3), BorderFactory .createLineBorder(Color.gray)); rightPanel.setBorder(cb);
		this.rightPanel.setBorder(cb);
		this.rightPanel.add(textCanvas, BorderLayout.EAST);

		start.addActionListener(this);
		// stop.addActionListener(this);

		// add button at the bottom
		this.bottomPanel = new JPanel();
		this.bottomPanel.add(start);
		this.bottomPanel.add(stop);
		this.bottomPanel.add(guess);
		this.bottomPanel.add(solve);

		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		add(rightPanel,BorderLayout.EAST);

		setFocusable(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

	@Override
	/*
	 * Connect the buttons with functions
	 * Confirmation pop-up when exit button is pressed
	 * */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			//optional for the number of players
			String[] options = {"3", "4"};
            int num = JOptionPane.showOptionDialog(null, "Number of Players", "Number of Players", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, options,options[0]);
            game.setNumPlayers(num);
            game.initial();
            //game.play();
		} else if (e.getActionCommand().equals("Stop")) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the game?", "stop game?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				//game.stop();
			}
		} else if (e.getActionCommand().equals("Guess")) {
			game.guess();
		} else if (e.getActionCommand().equals("Solve Attempt")) {
			game.solveAttempt();
		}
		//menu
		String menuItem = ((JMenuItem) e.getSource()).getText();
		if (menuItem.equals("Exit")) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}		
		boardCanvas.repaint();
		textCanvas.repaint();
	}
	
	/*
	 * once the player moves, the related canvas will be updated.
	 */
	public void updateMoving() {
		
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		BoardFrame bf = new BoardFrame(game);

    }

	
	
}
