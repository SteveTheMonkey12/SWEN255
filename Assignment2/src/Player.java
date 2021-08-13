/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 47 "model.ump"
/**
 * The Class representing Players.
 */
// line 112 "model.ump"
public class Player extends Moveable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  /** The items that a player holds. */
  //Player Associations
  private List<Item> items;
  
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aName, Position aPosition)
  {
    super(aName, aPosition);
    items = new ArrayList<Item>();
  }

  public Player(String aName) {
	super(aName);
	items = new ArrayList<Item>();
  }
  
  public Player(String aName, List<Item> someItems) {
		super(aName);
		items = someItems;
  }

//------------------------
  // INTERFACE
  //------------------------
  /**
 * Gets a specific item.
 *
 * @param index the index of the item
 * @return the item
 */
/* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }
  
  /**
   * Checks if player has the item.
   *
   * @param i the item
   * @return true, if has the item
   */
  public boolean hasItem(Item i) {
	  if(items.contains(i)){
		  return true;
	  }
	  return false;
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
   * Checks for items.
   *
   * @return true, if players have items
   */
  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  /**
   * Index of an item.
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
   * Adds an item.
   *
   * @param aItem the item
   * @return true, if item was added
   */
  /* Code from template association_AddUnidirectionalMany */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    wasAdded = true;
    return wasAdded;
  }

  /**
   * Removes an item.
   *
   * @param aItem the item
   * @return true, if item was removed
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
   * Adds the item at an index.
   *
   * @param aItem the item
   * @param index the index
   * @return true, if item added at the index
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
   * Adds or move item at.
   *
   * @param aItem the item
   * @param index the index
   * @return true, if item added or moved
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
   * Delete.
   */
  public void delete()
  {
    items.clear();
    super.delete();
  }

}