/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/
package Java;


// line 56 "model.ump"
// line 105 "model.ump"
public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int x;
  private int y;
  private Location location;
  
  public static enum Location{
	  HH("Haunted House",  2 , 2 , 6 , 6 , null,  new Position(6, 3, null), new Position(5, 6, null), null),//Top Left
	  MM("Manic Manor",    17, 2 , 21, 6 , null, null, new Position(20, 6, null), new Position(17,	5, null)),//top Right
	  
	  VC("Villa Celia",    9 , 10, 14, 13, new Position(12, 10, null), new Position(14, 11, null),
			  							   new Position(11, 13, null), new Position(9, 12, null)),// Middle
	  
	  CC("Calamity Castle",2 , 17, 6 , 21, new Position(3, 17, null), new Position(6, 18, null), null, null ),//Bottom Left
	  PP("Peril Palace",   17, 17, 21, 21, new Position(18, 17, null), null, null, new Position(17, 20, null));//Bottom Right
	  public final String name;
	  public final int x1, x2, y1, y2;
	  public final Position n,s,e,w;
	  
	  private Location(String name, int x1, int y1, int x2, int y2, Position n, Position e, Position s, Position w) {
		  this.name = name;
		  this.x1 = x1;
		  this.x2 = x2;
		  this.y1 = y1;
		  this.y2 = y2;
		  this.n = n;
		  this.e = e;
		  this.s = s;
		  this.w = w;
	  }
  }

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aX, int aY, Location aLocation)
  {
    x = aX;
    y = aY;
    location = aLocation;
  }

  //------------------------
  // INTERFACE
  //------------------------
  public boolean equals(Object o) {
	  if(o instanceof Position) {
		  Position other = (Position) o;
		  if(other.location == this.location && this.location != null) {
			  return true;
		  }else if(other.getX() == this.getX() && other.getY() == this.getY()) {
			  return true;
		  }
	  }
	  
	  return false;
  }
  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(Location aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public Location getLocation()
  {
    return location;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "x" + ":" + getX()+ "," +
            "y" + ":" + getY()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null");
  }
}