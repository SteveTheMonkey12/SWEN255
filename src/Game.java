/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 42 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Associations
  private List<Weapon> weapons;
  private List<Player> players;
  private List<Estate> estates;
  private List<Board> boards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game()
  {
    weapons = new ArrayList<Weapon>();
    players = new ArrayList<Player>();
    estates = new ArrayList<Estate>();
    boards = new ArrayList<Board>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Weapon getWeapon(int index)
  {
    Weapon aWeapon = weapons.get(index);
    return aWeapon;
  }

  public List<Weapon> getWeapons()
  {
    List<Weapon> newWeapons = Collections.unmodifiableList(weapons);
    return newWeapons;
  }

  public int numberOfWeapons()
  {
    int number = weapons.size();
    return number;
  }

  public boolean hasWeapons()
  {
    boolean has = weapons.size() > 0;
    return has;
  }

  public int indexOfWeapon(Weapon aWeapon)
  {
    int index = weapons.indexOf(aWeapon);
    return index;
  }
  /* Code from template association_GetMany */
  public Player getPlayer(int index)
  {
    Player aPlayer = players.get(index);
    return aPlayer;
  }

  public List<Player> getPlayers()
  {
    List<Player> newPlayers = Collections.unmodifiableList(players);
    return newPlayers;
  }

  public int numberOfPlayers()
  {
    int number = players.size();
    return number;
  }

  public boolean hasPlayers()
  {
    boolean has = players.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = players.indexOf(aPlayer);
    return index;
  }
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
  /* Code from template association_GetMany */
  public Board getBoard(int index)
  {
    Board aBoard = boards.get(index);
    return aBoard;
  }

  public List<Board> getBoards()
  {
    List<Board> newBoards = Collections.unmodifiableList(boards);
    return newBoards;
  }

  public int numberOfBoards()
  {
    int number = boards.size();
    return number;
  }

  public boolean hasBoards()
  {
    boolean has = boards.size() > 0;
    return has;
  }

  public int indexOfBoard(Board aBoard)
  {
    int index = boards.indexOf(aBoard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWeapons()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addWeapon(Weapon aWeapon)
  {
    boolean wasAdded = false;
    if (weapons.contains(aWeapon)) { return false; }
    weapons.add(aWeapon);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWeapon(Weapon aWeapon)
  {
    boolean wasRemoved = false;
    if (weapons.contains(aWeapon))
    {
      weapons.remove(aWeapon);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWeaponAt(Weapon aWeapon, int index)
  {  
    boolean wasAdded = false;
    if(addWeapon(aWeapon))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeapons()) { index = numberOfWeapons() - 1; }
      weapons.remove(aWeapon);
      weapons.add(index, aWeapon);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWeaponAt(Weapon aWeapon, int index)
  {
    boolean wasAdded = false;
    if(weapons.contains(aWeapon))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeapons()) { index = numberOfWeapons() - 1; }
      weapons.remove(aWeapon);
      weapons.add(index, aWeapon);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWeaponAt(aWeapon, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayers()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    players.add(aPlayer);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (players.contains(aPlayer))
    {
      players.remove(aPlayer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(players.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEstates()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addEstate(Estate aEstate)
  {
    boolean wasAdded = false;
    if (estates.contains(aEstate)) { return false; }
    estates.add(aEstate);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEstate(Estate aEstate)
  {
    boolean wasRemoved = false;
    if (estates.contains(aEstate))
    {
      estates.remove(aEstate);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBoards()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addBoard(Board aBoard)
  {
    boolean wasAdded = false;
    if (boards.contains(aBoard)) { return false; }
    boards.add(aBoard);
    if (aBoard.indexOfGame(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aBoard.addGame(this);
      if (!wasAdded)
      {
        boards.remove(aBoard);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeBoard(Board aBoard)
  {
    boolean wasRemoved = false;
    if (!boards.contains(aBoard))
    {
      return wasRemoved;
    }

    int oldIndex = boards.indexOf(aBoard);
    boards.remove(oldIndex);
    if (aBoard.indexOfGame(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aBoard.removeGame(this);
      if (!wasRemoved)
      {
        boards.add(oldIndex,aBoard);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBoardAt(Board aBoard, int index)
  {  
    boolean wasAdded = false;
    if(addBoard(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBoardAt(Board aBoard, int index)
  {
    boolean wasAdded = false;
    if(boards.contains(aBoard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBoards()) { index = numberOfBoards() - 1; }
      boards.remove(aBoard);
      boards.add(index, aBoard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBoardAt(aBoard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    weapons.clear();
    players.clear();
    estates.clear();
    ArrayList<Board> copyOfBoards = new ArrayList<Board>(boards);
    boards.clear();
    for(Board aBoard : copyOfBoards)
    {
      aBoard.removeGame(this);
    }
  }

  // line 4 "model.ump"
   private Card playerGuessResponse(Player aPlayer, Player guessedPlayer, Weapon guessedWeapon, Estate guessedEstate){
    return null;
  }

  // line 5 "model.ump"
   public int guess(Player p){
    return 0;
  }

}