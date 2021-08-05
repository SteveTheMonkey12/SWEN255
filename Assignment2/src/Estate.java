/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 77 "model.ump"
// line 140 "model.ump"
public class Estate extends NonMoveable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Estate Associations
  private List<Moveable> moveables;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Estate(String aName, Position aPosition)
  {
    super(aName, aPosition);
    moveables = new ArrayList<Moveable>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Moveable getMoveable(int index)
  {
    Moveable aMoveable = moveables.get(index);
    return aMoveable;
  }

  public List<Moveable> getMoveables()
  {
    List<Moveable> newMoveables = Collections.unmodifiableList(moveables);
    return newMoveables;
  }

  public int numberOfMoveables()
  {
    int number = moveables.size();
    return number;
  }

  public boolean hasMoveables()
  {
    boolean has = moveables.size() > 0;
    return has;
  }

  public int indexOfMoveable(Moveable aMoveable)
  {
    int index = moveables.indexOf(aMoveable);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMoveables()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addMoveable(Moveable aMoveable)
  {
    boolean wasAdded = false;
    if (moveables.contains(aMoveable)) { return false; }
    moveables.add(aMoveable);
    if (aMoveable.indexOfEstate(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMoveable.addEstate(this);
      if (!wasAdded)
      {
        moveables.remove(aMoveable);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeMoveable(Moveable aMoveable)
  {
    boolean wasRemoved = false;
    if (!moveables.contains(aMoveable))
    {
      return wasRemoved;
    }

    int oldIndex = moveables.indexOf(aMoveable);
    moveables.remove(oldIndex);
    if (aMoveable.indexOfEstate(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMoveable.removeEstate(this);
      if (!wasRemoved)
      {
        moveables.add(oldIndex,aMoveable);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMoveableAt(Moveable aMoveable, int index)
  {  
    boolean wasAdded = false;
    if(addMoveable(aMoveable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMoveables()) { index = numberOfMoveables() - 1; }
      moveables.remove(aMoveable);
      moveables.add(index, aMoveable);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMoveableAt(Moveable aMoveable, int index)
  {
    boolean wasAdded = false;
    if(moveables.contains(aMoveable))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMoveables()) { index = numberOfMoveables() - 1; }
      moveables.remove(aMoveable);
      moveables.add(index, aMoveable);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMoveableAt(aMoveable, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Moveable> copyOfMoveables = new ArrayList<Moveable>(moveables);
    moveables.clear();
    for(Moveable aMoveable : copyOfMoveables)
    {
      aMoveable.removeEstate(this);
    }
    super.delete();
  }

}