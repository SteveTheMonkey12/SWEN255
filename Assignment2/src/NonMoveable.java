


// TODO: Auto-generated Javadoc
// line 66 "model.ump"
/**
 * The Class NonMoveable representing walls and estates.
 */
// line 129 "model.ump"
public abstract class NonMoveable extends Item
{

  //------------------------
  // MEMBER VARIABLES
  /** The bottom right position. */
  //------------------------
	private Position bottomRightPosition;
	 
  //------------------------
  // CONSTRUCTOR
  //------------------------

  /**
   * Instantiates a new non moveable.
   *
   * @param aName Name of NonMovable
   * @param aPosition Top Left position
   * @param bPosition Bottom Right Position
   */
public NonMoveable(String aName, Position aPosition, Position bPosition)
  {
    super(aName, aPosition);
    bottomRightPosition = bPosition;
  }
  
  /**
   * Gets the bottom right position.
   *
   * @return the bottom right position
   */
  public Position getBottomRightPosition() {
	  return this.bottomRightPosition;
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Delete.
   */
  public void delete()
  {
    super.delete();
  }
  
}