/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/



// line 72 "model.ump"
/**
 * The Class representing Walls.
 */
// line 135 "model.ump"
public class Wall extends NonMoveable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Wall(String aName, Position aPosition, Position bPosition)
  {
    super(aName, aPosition, bPosition);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
  
  /**
   * Collides with a position, for example a position a player might be in.
   *
   * @param p the position
   * @return true, if the wall intersects the position
   */
  @Override
  public boolean collidesWith(Position p) {
	  Position myTopLeft = super.getPosition();
	  Position myBottomRight = super.getBottomRightPosition();
	  
	  if(myTopLeft.getX() <= p.getX() && p.getX() <= myBottomRight.getX()) {//within the x
		  if(myTopLeft.getY() <= p.getY() && p.getY() <= myBottomRight.getY()) {//within the y
			  return true;
		  }
	  }
	  return false;
  }

}