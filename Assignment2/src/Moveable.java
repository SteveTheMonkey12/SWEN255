/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 30 "model.ump"
// line 92 "model.ump"
public class Moveable extends Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Moveable Associations
  private List<Estate> estates;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Moveable(String aName, Position aPosition)
  {
    super(aName, aPosition);
    estates = new ArrayList<Estate>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Estate getEstate(int index)
  {
    Estate aEstate = estates.get(index);
    return aEstate;
  }

  public List<Estate> getEstates()
  {
    List<Estate> newEstates = Collections.unmodifiableList(estates);
    return newEstates;
  }

  public int numberOfEstates()
  {
    int number = estates.size();
    return number;
  }

  public boolean hasEstates()
  {
    boolean has = estates.size() > 0;
    return has;
  }

  public int indexOfEstate(Estate aEstate)
  {
    int index = estates.indexOf(aEstate);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEstates()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addEstate(Estate aEstate)
  {
    boolean wasAdded = false;
    if (estates.contains(aEstate)) { return false; }
    estates.add(aEstate);
    if (aEstate.indexOfMoveable(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEstate.addMoveable(this);
      if (!wasAdded)
      {
        estates.remove(aEstate);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeEstate(Estate aEstate)
  {
    boolean wasRemoved = false;
    if (!estates.contains(aEstate))
    {
      return wasRemoved;
    }

    int oldIndex = estates.indexOf(aEstate);
    estates.remove(oldIndex);
    if (aEstate.indexOfMoveable(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEstate.removeMoveable(this);
      if (!wasRemoved)
      {
        estates.add(oldIndex,aEstate);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEstateAt(Estate aEstate, int index)
  {  
    boolean wasAdded = false;
    if(addEstate(aEstate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEstates()) { index = numberOfEstates() - 1; }
      estates.remove(aEstate);
      estates.add(index, aEstate);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEstateAt(Estate aEstate, int index)
  {
    boolean wasAdded = false;
    if(estates.contains(aEstate))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEstates()) { index = numberOfEstates() - 1; }
      estates.remove(aEstate);
      estates.add(index, aEstate);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEstateAt(aEstate, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Estate> copyOfEstates = new ArrayList<Estate>(estates);
    estates.clear();
    for(Estate aEstate : copyOfEstates)
    {
      aEstate.removeMoveable(this);
    }
    super.delete();
  }

  // line 33 "model.ump"
   public boolean Move(){
    return false;
  }

}