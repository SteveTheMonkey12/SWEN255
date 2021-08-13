/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/



// line 52 "model.ump"
/**
 * The Class Item represents the items that players can hold.
 */
// line 117 "model.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  /** The name of the item. */
  //Item Attributes
  private String name;

  /** The position of the item. */
  //Item Associations
  private Position position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(String aName, Position aPosition)
  {
    name = aName;
    if (!setPosition(aPosition))
    {
      throw new RuntimeException("Unable to create Item due to aPosition. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }
  public Item(String aName)
  {
    name = aName;
    position = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Sets the name.
   *
   * @param aName the name
   * @return true, if successful
   */
  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * Gets the position.
   *
   * @return the position
   */
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  
  /**
   * Clear position.
   */
  /* Code from template association_GetOne_clear */
  protected void clear_position()
  {
    position = null;
  }
  
  /**
   * Sets the position.
   *
   * @param aNewPosition the new position
   * @return true, if successful
   */
  /* Code from template association_SetUnidirectionalOne */
  public boolean setPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    if (aNewPosition != null)
    {
      position = aNewPosition;
      wasSet = true;
    }
    return wasSet;
  }

  /**
   * Delete.
   */
  public void delete()
  {
    position = null;
  }

  // line 55 "model.ump"
   public boolean Display(){
    return false;
  }
   
   /**
    * @param p the Postion to check if a collisions occurs at
    * @return true, if p will overlaps with this's position
    */
  public boolean collidesWith(Position p) {
	   return false;
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}