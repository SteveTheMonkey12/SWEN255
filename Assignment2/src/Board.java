/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 41 "model.ump"
// line 105 "model.ump"
public class Board
{
	
	public static enum direction{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
  private Game game;
  private List<Item> items;
  private ArrayList<Estate> estates = new ArrayList<Estate>();

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(Game aGame)
  {
    if (aGame == null || aGame.getBoard() != null)
    {
      throw new RuntimeException("Unable to create Board due to aGame. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    game = aGame;
    items = new ArrayList<Item>();
  }

  public Board()
  {
    game = new Game();
    items = new ArrayList<Item>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Game getGame()
  {
    return game;
  }
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
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
	  * Use this for processing a raw string direction input or 
	 * @param Dir nwes or wasd either will be parsed
	 * @param p
	 * @return returns true if a move was successuful
	 */
	public boolean movePlayer(String Dir, Player p) {
		
		return false;
	}
	public boolean moveToClick(Position pos, Player p) {
		return true;//if it's allowed
	}
	public boolean movePlayerToEstate(Player p, Estate e) {
		p.getPosition().setX(e.getPosition().getX());
		p.getPosition().setY(e.getPosition().getY());
		e.addMoveable(p);
		
		return true;
	}
	
	public Estate getMoveableEstate(Moveable m) {
		for(Estate e: estates) {
			if(e.getMoveables().contains(m)){
				return e;
			}
		}
		return null;
		
	}



	/**
	* @param dir the board direction, u
	* @param p
	* @return returns true if a move was successuful
	 * @throws Board.BoardException 
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
						return movePlayerToEstate(p, e);
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
	public class BoardException extends Exception {

	    public BoardException(String message) {
	        super(message);
	    }

	}
}