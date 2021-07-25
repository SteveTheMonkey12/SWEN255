/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


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
	  HH("Haunted House",  2 , 2 , 6 , 6 ),//Top Left
	  MM("Manic Manor",    17, 2 , 17, 6 ),//top Right
	  
	  VC("Villa Celia",    9 , 10, 14, 13),// Middle
	  
	  CC("Calamity Castle",2 , 17, 6 , 21),//Bottom Left
	  PP("Peril Palace",   17, 17, 21, 21);//Bottom Right
	  public final String name;
	  public final int x1, x2, y1, y2;
	  private Location(String n, int x1, int y1, int x2, int y2) {
		  this.name = n;
		  this.x1 = x1;
		  this.x2 = x2;
		  this.y1 = y2;
		  this.y2 = y2;
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