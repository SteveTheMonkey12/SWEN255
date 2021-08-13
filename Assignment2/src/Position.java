/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/



// line 88 "model.ump"
/**
 * The Class Position represents squares on the board.
 */
// line 151 "model.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int x;
  private int y;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aX, int aY)
  {
    x = aX;
    y = aY;
  }
  public Position(Position p) {
	  x = p.getX();
	  y = p.getY();
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Sets the X part of the position.
   *
   * @param aX the X
   * @return true, if successful
   */
  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  /**
   * Sets the Y part of the position.
   *
   * @param aY the a Y
   * @return true, if successful
   */
  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  /**
   * Gets the x.
   *
   * @return the x
   */
  public int getX()
  {
    return x;
  }

  /**
   * Gets the y.
   *
   * @return the y
   */
  public int getY()
  {
    return y;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "]";
  }
  
  /**
   * Checks if two positions are the same equals.
   *
   * @param p the position to be compared
   * @return true, if the positions are in the same coordinates
   */
  public boolean equals(Position p) {
	  if(x == p.getX() && y == p.getY()) {
		  return true;
	  }
	  return false;
  }
  public double distanceTo(Position p) {
	  
	  return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2) );
	  
  }
}