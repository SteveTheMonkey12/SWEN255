/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// TODO: Auto-generated Javadoc
// line 41 "model.ump"
/**
 * The Class Board represents the board the players play on.
 */
// line 105 "model.ump"
public class Board
{
	
	/**
	 * The Enum direction.
	 */
	public static enum direction{
		
		/** Up. */
		UP,
		
		/** Down. */
		DOWN,
		
		/** Left. */
		LEFT,
		
		/** Right. */
		RIGHT
	}
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  /** The game. */
  //Board Associations
  private Game game;
  
  /** The items. */
  private List<Item> items;
  
  /** The estates. */
  private ArrayList<Estate> estates = new ArrayList<Estate>();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  /**
   * Instantiates a new board.
   *
   * @param aGame the game
   */
  public Board(Game aGame)
  {
    if (aGame == null || aGame.getBoard() != null)
    {
      throw new RuntimeException("Unable to create Board due to aGame. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    game = aGame;
    items = new ArrayList<Item>();
  }

  /**
   * Instantiates a new board.
   */
  public Board()
  {
    game = new Game();
    items = new ArrayList<Item>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Gets the game.
   *
   * @return the game
   */
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  
  /**
   * Gets the item.
   *
   * @param index of item
   * @return the item
   */
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  /**
   * Number of items.
   *
   * @return the number of items
   */
  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  /**
   * Checks if the board has items.
   *
   * @return true, if successful
   */
  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  /**
   * Index of item.
   *
   * @param aItem the item
   * @return the index of the item
   */
  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  
  /**
   * Minimum number of items.
   *
   * @return the minimum number of items
   */
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  
  /**
   * Adds the item.
   *
   * @param aItem the item
   * @return true, if successful
   */
  /* Code from template association_AddUnidirectionalMany */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    if(aItem instanceof Estate) {
		estates.add((Estate) aItem);
	}
    wasAdded = true;
    return wasAdded;
  }

  /**
   * Removes the item.
   *
   * @param aItem the item
   * @return true, if successful
   */
  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (items.contains(aItem))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  
  /**
   * Adds the item at.
   *
   * @param aItem the item
   * @param index the index of the item
   * @return true, if successful
   */
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  /**
   * Adds the or move item at.
   *
   * @param aItem the item
   * @param index the index of the item
   * @return true, if successful
   */
  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  /**
   * Delete the board.
   */
  public void delete()
  {
    Game existingGame = game;
    game = null;
    if (existingGame != null)
    {
      existingGame.delete();
    }
    items.clear();
  }
	 
 	/**
 	 * Use this for processing a raw string direction input or .
 	 *
 	 * @param dir the direction
 	 * @param p the player
 	 * @return returns true if a move was successful
 	 */
	public boolean movePlayer(String dir, Player p) {
		try {
			if(dir.equals("w")) {
				return movePlayer(direction.UP, p);
			}else if(dir.equals("d")) {
				return movePlayer(direction.RIGHT, p);
			}else if(dir.equals("s")) {
				return movePlayer(direction.DOWN, p);
			}else if(dir.equals("a")) {
				return movePlayer(direction.LEFT, p);
			}		
		} catch (Board.BoardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Move to click.
	 *
	 * @param pos the position
	 * @param p the player
	 * @param turns the turns a player has left
	 * @return the 
	 */
	public int moveToClick(Position pos, Player p, int turns) {
		if(turns < 1) {
			System.out.println("No turns remaining");
			return -1;
		}
		Position toEvaluate;
		Estate currentEstate = getMoveableEstate(p);
		if(currentEstate != null) {
			//move player to the doorway if they're in an estate
			double smallestD = 1000;
			direction dir = null;
			for(Map.Entry<direction, Position> door: currentEstate.getDoorways().entrySet()) {
				if(pos.distanceTo(door.getValue()) < smallestD) {
					smallestD = pos.distanceTo(door.getValue());
					dir = door.getKey();
				}
			}
			
			toEvaluate =  new Position(currentEstate.doorways.get(dir));
			
		}else {
			toEvaluate = new Position(p.getPosition());
		}
		
		boolean moved = false;
		int deltaX = pos.getX() - toEvaluate.getX() ;
		int deltaY = pos.getY() - toEvaluate.getY() ;
		try {
			if(deltaX == 1 && deltaY == 0) {
				moved = movePlayer(direction.RIGHT, p);
			} else if(deltaX == -1 && deltaY == 0) {
				moved = movePlayer(direction.LEFT, p);
			}if(deltaX == 0 && deltaY == 1) {
				moved = movePlayer(direction.DOWN, p);
			}if(deltaX == 0 && deltaY == -1) {
				moved = movePlayer(direction.UP, p);
			}
		} catch (Board.BoardException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(moved) {
			return 1;
		}
		System.out.println("You clicked at x = " + pos.getX() + " y = " + pos.getY());
		System.out.println("Player is   at x = " + p.getPosition().getX() + " y = " + p.getPosition().getY());
		System.out.println("Delta is       x = " + deltaX + " y = " + deltaY);
		System.out.print("\n");
		return -1;//if it's allowed
	}
	
	/**
	 * Move a moveable to an estate.
	 *
	 * @param p the moveable object
	 * @param e the estate
	 * @return true, if successful
	 */
	public boolean moveMoveableToEstate(Moveable p, Estate e) {
		p.getPosition().setX(e.getPosition().getX());
		p.getPosition().setY(e.getPosition().getY());
		e.addMoveable(p);
		
		return true;
	}
	
	/**
	 * Gets the estate that a moveable is in.
	 *
	 * @param m the moveable
	 * @return the estate the moveable is in
	 */
	public Estate getMoveableEstate(Moveable m) {
		for(Estate e: estates) {
			if(e.getMoveables().contains(m)){
				return e;
			}
		}
		return null;
		
	}



	/**
	 * Move player.
	 *
	 * @param dir the direction to move
	 * @param p the player
	 * @return returns true if a move was successful
	 * @throws BoardException the move failed
	 */
	public boolean movePlayer(direction dir, Player p) throws Board.BoardException {
		if(dir == null) { throw new BoardException("Direction Cannot Be null");}
		if(p == null) {	  throw new BoardException("Player Cannot Be null"   );}
		
		
		Position toEvaluate;

		
		Estate currentEstate = getMoveableEstate(p);
		if(currentEstate != null) {
			//move player to the doorway if they're in an estate
			toEvaluate =  new Position(currentEstate.doorways.get(dir));
			
		}else {
			toEvaluate = new Position(p.getPosition());
		}
		
		if(dir == direction.UP) {
			toEvaluate.setY(toEvaluate.getY() -1 );
			
		}else if(dir == direction.DOWN) {
			toEvaluate.setY(toEvaluate.getY() + 1 );
		}else if(dir == direction.LEFT) {
			toEvaluate.setX(toEvaluate.getX() - 1 );
		}else if(dir == direction.RIGHT) {
			toEvaluate.setX(toEvaluate.getX() + 1 );
		}
		
		
		//First Check if going into an estate
		for(Estate e: estates) {
			if(e.collidesWith(toEvaluate)) {
				for(Position doorway: e.getDoorways().values()) {
					if(doorway.equals(toEvaluate)) {
						return moveMoveableToEstate(p, e);
					}
				}
				//if a player is in the wall of an estate there is no need to check the others
				break;
			}
		}
		
		//Check if colliding with anything else;
		for(Item i: items) {
			if(i.collidesWith(toEvaluate)) {
				return false;
			}
		}
		//Collides with nothing and Isn't moving into an estate so everything should be fine	
		//this time instead of overwriting Position, keep it as the same object but update the fields
		p.getPosition().setX(toEvaluate.getX());
		p.getPosition().setY(toEvaluate.getY());
		//and Also Remember to remove them from the estate if they were in one
		if(currentEstate != null) {
			currentEstate.removeMoveable(p);
		}
		return true;
	  
	}
	
	/**
	 * The Class BoardException.
	 */
	public class BoardException extends Exception {

	    /**
    	 * Instantiates a new board exception.
    	 *
    	 * @param message the message
    	 */
    	public BoardException(String message) {
	        super(message);
	    }

	}
}