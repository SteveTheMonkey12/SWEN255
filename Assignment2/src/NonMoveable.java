


// line 66 "model.ump"
// line 129 "model.ump"
public abstract class NonMoveable extends Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
	private Position bottomRightPosition;
	 
  //------------------------
  // CONSTRUCTOR
  //------------------------

  /**
 * @param aName Name of NonMovable
 * @param aPosition Top Left position
 * @param bPosition Bottom Right Position
 */
public NonMoveable(String aName, Position aPosition, Position bPosition)
  {
    super(aName, aPosition);
    bottomRightPosition = bPosition;
  }
  public Position getBottomRightPosition() {
	  return this.bottomRightPosition;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
  
}