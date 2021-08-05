/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/



// line 52 "model.ump"
// line 117 "model.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private String name;

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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public Position getPosition()
  {
    return position;
  }
  /* Code from template association_GetOne_clear */
  protected void clear_position()
  {
    position = null;
  }
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

  public void delete()
  {
    position = null;
  }

  // line 55 "model.ump"
   public boolean Display(){
    return false;
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position = "+(getPosition()!=null?Integer.toHexString(System.identityHashCode(getPosition())):"null");
  }
}