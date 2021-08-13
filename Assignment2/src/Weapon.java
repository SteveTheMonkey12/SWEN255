/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 83 "model.ump"
/**
 * The Class representing Weapons.
 */
// line 146 "model.ump"
public class Weapon extends Moveable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Weapon(String aName, Position aPosition)
  {
    super(aName, aPosition);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Weapon(String aName) {
	super(aName);
}

public void delete()
  {
    super.delete();
  }

}