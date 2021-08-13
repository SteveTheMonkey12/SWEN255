import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * According to the MVC, this class will control the model and view. Once user has an action, 
 * it will update the model and view.
 * @author pengailin
 *
 */
public class Controller implements MouseListener, KeyListener {

	private static final int SQUARE_WIDTH = 36;
	private static final int SQUARE_HEIGHT = 36;
	
	private Game game;
	private BoardFrame bf;
	private BoardCanvas bc;
	private TextCanvas tc;

    public Controller(Game game, BoardFrame bf, BoardCanvas bc, TextCanvas tc) {
    	this.game = game;
    	this.bf = bf;
    	this.bc = bc;
    	this.tc = tc;
		//add mouse and key listener
		bc.addMouseListener(this);
		bc.addKeyListener(this);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Player currentP = game.getCurrentPlayer();
		int posX = currentP.getPosition().getX();//x pos of current player
		int posY = currentP.getPosition().getY();//x pos of current player

		if(e.getKeyChar()=='w' || e.getKeyChar()=='W') {
			bf.takeTurn(new Position(posX, posY-1));
		}
		else if(e.getKeyChar()=='s' || e.getKeyChar()=='S') {
			bf.takeTurn(new Position(posX, posY+1));
		}
		else if(e.getKeyChar()=='a' || e.getKeyChar()=='A') {
			bf.takeTurn(new Position(posX-1, posY));
		}
		else if(e.getKeyChar()=='d' || e.getKeyChar()=='D') {
			bf.takeTurn(new Position(posX+1, posY));
		}	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/*
	 * Finds the position when mouse is released 
	 */
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Position pos = new Position(x / SQUARE_WIDTH, y / SQUARE_HEIGHT);
		bf.takeTurn(pos);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
}
