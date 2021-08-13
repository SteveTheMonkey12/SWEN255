/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 60 "model.ump"
/**
 * The Class Moveable represents player or weapon.
 */
// line 124 "model.ump"
public class Moveable extends Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  /** The estate that an object could be in. */
  //Moveable Associations
  private Estate estate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  /**
   * Instantiates a new moveable.
   *
   * @param aName the name
   * @param aPosition the position
   */
  public Moveable(String aName, Position aPosition)
  {
    super(aName, aPosition);
    estate = null;
  }
  
  /**
   * Instantiates a new moveable.
   *
   * @param aName the name
   */
  public Moveable(String aName)
  {
    super(aName);
    estate = null;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Gets the estate.
   *
   * @return the estate
   */
  /* Code from template association_GetMany */
  public Estate getEstate()
  {
    return this.estate;
  }

 /**
  * Sets the estate.
  *
  * @param e the new estate
  */
 public void setEstate(Estate e) {
	 this.estate = e;
 }

  /**
   * Delete.
   */
  public void delete()
  {
    super.delete();
  }

}