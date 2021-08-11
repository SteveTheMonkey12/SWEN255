/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 60 "model.ump"
// line 124 "model.ump"
public class Moveable extends Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Moveable Associations
  private Estate estate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Moveable(String aName, Position aPosition)
  {
    super(aName, aPosition);
    estate = null;
  }
  public Moveable(String aName)
  {
    super(aName);
    estate = null;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Estate getEstate()
  {
    return this.estate;
  }

 public void setEstate(Estate e) {
	 this.estate = e;
 }

  public void delete()
  {
    super.delete();
  }

}