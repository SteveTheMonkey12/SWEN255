/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 77 "model.ump"
/**
 * The Class Estate represents the locations the characters can go to.
 */
// line 140 "model.ump"
public class Estate extends NonMoveable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  /** The moveable objects that could be inside the estate. */
  //Estate Associations
  private List<Moveable> moveables;
  
  /** The doorways in the estate. */
  HashMap<Board.direction, Position> doorways = new HashMap<Board.direction, Position>();
  //------------------------
  // CONSTRUCTOR
  //------------------------


/**
   * Instantiates a new estate.
   *
   * @param aName the name
   * @param aPosition the top left position
   * @param bPosition the bottom right position
   */
  public Estate(String aName, Position aPosition, Position bPosition)
  {
    super(aName, aPosition, bPosition);
    moveables = new ArrayList<Moveable>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Gets the movable object from the index.
   *
   * @param index the index
   * @return the moveable
   */
  public Moveable getMoveable(int index)
  {
    Moveable aMoveable = moveables.get(index);
    return aMoveable;
  }

  /**
   * Gets the moveables in the estate.
   *
   * @return the moveables
   */
  public List<Moveable> getMoveables()
  {
    List<Moveable> newMoveables = Collections.unmodifiableList(moveables);
    return newMoveables;
  }

  /**
   * How many movables are in the estate.
   *
   * @return the moveables of objects in the estate
   */
  public int numberOfMoveables()
  {
    int number = moveables.size();
    return number;
  }

  /**
   * Checks if anything is inside the estate.
   *
   * @return true, if there are things in the estate
   */
  public boolean hasMoveables()
  {
    boolean has = moveables.size() > 0;
    return has;
  }

  /**
   * Index of moveable.
   *
   * @param aMoveable the moveable that is being checked for
   * @return the index
   */
  public int indexOfMoveable(Moveable aMoveable)
  {
    int index = moveables.indexOf(aMoveable);
    return index;
  }
  
  /**
   * Minimum number of moveables.
   *
   * @return the minimum number of objects the estate can contain
   */
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMoveables()
  {
    return 0;
  }
  
  /**
   * Adds the moveable.
   *
   * @param aMoveable the moveable
   * @return true, if successful
   */
  /* Code from template association_AddManyToManyMethod */
  public boolean addMoveable(Moveable aMoveable)
  {
    if (moveables.contains(aMoveable)) { return false; }
    moveables.add(aMoveable);
    aMoveable.setEstate(this);
    return true;
  }
  
  /**
   * Removes the moveable.
   *
   * @param aMoveable the moveable
   * @return true, if successful
   */
  /* Code from template association_RemoveMany */
  public boolean removeMoveable(Moveable aMoveable)
  {
    boolean wasRemoved = false;
    if (!moveables.contains(aMoveable))
    {
      return wasRemoved;
    }
    aMoveable.setEstate(null);
    moveables.remove(aMoveable);
    return true;
  }
  
  /**
   * Adds the moveable at an index.
   *
   * @param aMoveable the moveable
   * @param index the index
   * @return true, if successful
   */
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMoveableAt(Moveable aMoveable, int index)
  {  
    boolean wasAdded = false;
    if(addMoveable(aMoveable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMoveables()) { index = numberOfMoveables() - 1; }
      moveables.remove(aMoveable);
      moveables.add(index, aMoveable);
      wasAdded = true;
    }
    return wasAdded;
  }

  /**
   * Adds or move moveable at an index.
   *
   * @param aMoveable the moveable
   * @param index the index
   * @return true, if successful
   */
  public boolean addOrMoveMoveableAt(Moveable aMoveable, int index)
  {
    boolean wasAdded = false;
    if(moveables.contains(aMoveable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMoveables()) { index = numberOfMoveables() - 1; }
      moveables.remove(aMoveable);
      moveables.add(index, aMoveable);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMoveableAt(aMoveable, index);
    }
    return wasAdded;
  }

  /**
   * Delete.
   */
  public void delete()
  {
    ArrayList<Moveable> copyOfMoveables = new ArrayList<Moveable>(moveables);
    moveables.clear();
    for(Moveable aMoveable : copyOfMoveables)
    {
      aMoveable.setEstate(null);
    }
    super.delete();
  }
  
  /**
   * Checks if the estate collides with a position, e.g. a person inside the estate.
   *
   * @param p the position
   * @return true, if successful
   */
  @Override
  public boolean collidesWith(Position p) {
	  
	  
	  //Check if they're on the perimiter
	  
	  Position myTopLeft = super.getPosition();
	  Position myBottomRight = super.getBottomRightPosition();
	  
	  if(myTopLeft.getX() <= p.getX() && p.getX() <= myBottomRight.getX()) {//within the x
		  if(p.getY() == myTopLeft.getY() || p.getY() == myBottomRight.getY()) {
			  //If they're inside the Estates x bounds and their at the y bounds, then they must be inside a wall
			  return true;
		  }
	  }
	  if(myTopLeft.getY() <= p.getY() && p.getY() <= myBottomRight.getY()) {//within the y
		  if(p.getX() == myTopLeft.getX() || p.getX() == myBottomRight.getX()) {
			  //If they're inside the Estates x bounds and their at the y bounds, then they must be inside a wall
			  return true;
		  }
	  }
	  return false;
  }
  
  /**
   * Adds a doorway.
   *
   * @param d Which Face of the building the door is on for exiting
   * @param p where the doorway is on the board
   */
  public void addDoorway(Board.direction d, Position p) {
	doorways.put(d, p);
  }
  
  /**
   * Gets the doorways.
   *
   * @return the doorways
   */
  public HashMap<Board.direction, Position> getDoorways(){
	  return doorways;
  }

}