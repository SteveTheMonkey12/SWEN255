/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 59 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private HashMap position;

  //Game Associations
  private List<Player> players;
  private List<Position> positions;
  private List<Board> boards;
  private List<Card> cards;
  private ArrayList<Card> weapons; //needed for guesses
  private ArrayList<Card> estates;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(HashMap aPosition)
  {
    position = aPosition;
    players = new ArrayList<Player>();
    positions = new ArrayList<Position>();
    boards = new ArrayList<Board>();
    cards = new ArrayList<Card>();
    for(int i = 0; i < numberOfCards(); i++) {
		  if(getCard(i) instanceof Weapon) {
			  weapons.add(getCard(i));
		  }
		  if(getCard(i) instanceof Estate) {
			  estates.add(getCard(i));
		  }
	  }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPosition(HashMap aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public HashMap getPosition()
  {
    return position;
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
  
  /**
   * Method to get the next player in the list
   * @param aPlayer
   * @return The next player in the list
   */
  public Player getNextPlayer(Player aPlayer) {
	  int index = indexOfPlayer(aPlayer);
	  if(index == numberOfPlayers()-1) {
		  index = 0;
	  }
	  else {
		  index++;
	  }
	  return getPlayer(index);
  }
  /* Code from template association_GetMany */
  public Position getPosition(int index)
  {
    Position aPosition = positions.get(index);
    return aPosition;
  }

  public List<Position> getPositions()
  {
    List<Position> newPositions = Collections.unmodifiableList(positions);
    return newPositions;
  }

  public int numberOfPositions()
  {
    int number = positions.size();
    return number;
  }

  public boolean hasPositions()
  {
    boolean has = positions.size() > 0;
    return has;
  }

  public int indexOfPosition(Position aPosition)
  {
    int index = positions.indexOf(aPosition);
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
  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayers()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    players.add(aPlayer);
    if (aPlayer.indexOfGame(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPlayer.addGame(this);
      if (!wasAdded)
      {
        players.remove(aPlayer);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (!players.contains(aPlayer))
    {
      return wasRemoved;
    }

    int oldIndex = players.indexOf(aPlayer);
    players.remove(oldIndex);
    if (aPlayer.indexOfGame(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPlayer.removeGame(this);
      if (!wasRemoved)
      {
        players.add(oldIndex,aPlayer);
      }
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
  public static int minimumNumberOfPositions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPosition(Position aPosition)
  {
    boolean wasAdded = false;
    if (positions.contains(aPosition)) { return false; }
    positions.add(aPosition);
    if (aPosition.indexOfGame(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPosition.addGame(this);
      if (!wasAdded)
      {
        positions.remove(aPosition);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePosition(Position aPosition)
  {
    boolean wasRemoved = false;
    if (!positions.contains(aPosition))
    {
      return wasRemoved;
    }

    int oldIndex = positions.indexOf(aPosition);
    positions.remove(oldIndex);
    if (aPosition.indexOfGame(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPosition.removeGame(this);
      if (!wasRemoved)
      {
        positions.add(oldIndex,aPosition);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPositionAt(Position aPosition, int index)
  {  
    boolean wasAdded = false;
    if(addPosition(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePositionAt(Position aPosition, int index)
  {
    boolean wasAdded = false;
    if(positions.contains(aPosition))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPositions()) { index = numberOfPositions() - 1; }
      positions.remove(aPosition);
      positions.add(index, aPosition);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPositionAt(aPosition, index);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    cards.add(aCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    if (cards.contains(aCard))
    {
      cards.remove(aCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Player> copyOfPlayers = new ArrayList<Player>(players);
    players.clear();
    for(Player aPlayer : copyOfPlayers)
    {
      aPlayer.removeGame(this);
    }
    ArrayList<Position> copyOfPositions = new ArrayList<Position>(positions);
    positions.clear();
    for(Position aPosition : copyOfPositions)
    {
      aPosition.removeGame(this);
    }
    ArrayList<Board> copyOfBoards = new ArrayList<Board>(boards);
    boards.clear();
    for(Board aBoard : copyOfBoards)
    {
      aBoard.removeGame(this);
    }
    cards.clear();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null");
  }
  
  //Elliott's guess stuff
  
  
  /**
   * Starts the guessing sequence from a given player
   * @param p the player that is having a guess
   * @return -1 if bad input, 0 if no guess, 1 if guess
   */
  
  public int guess(Player p) {
	  System.out.flush();
	  System.out.print(p.getName() + "'s guess y/n\n");
	  Scanner input = new Scanner(System.in);
	  String guess = input.next();
	  if(!guess.equals("y") || !guess.equals("n")) {
		  return -1;
	  }
	  else if(guess.equals("n")) {
		  return 0;
	  }
	  else if(guess.equals("y")) {
		  System.out.flush();
		  //guess weapon
		  System.out.println("Guess a weapon 1-" + weapons.size() + ":");
		  String tmpOutput = "";
		  for(int i = 0; i < weapons.size(); i++) {
			  tmpOutput += i + ")" + weapons.get(i).getName();
		  }
		  System.out.println(tmpOutput);
		  input = new Scanner(System.in);
		  int guessNum = input.nextInt();
		  if(guessNum < 0 || guessNum > weapons.size()) {
			  return -1;
		  }
		  Weapon guessedWeapon = (Weapon) weapons.get(guessNum);
		  //guess estate
		  System.out.flush();
		  System.out.println("Guess an Estate 1-" + estates.size() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < estates.size(); i++) {
			  tmpOutput += i + ")" + estates.get(i).getName();
		  }
		  System.out.println(tmpOutput);
		  input = new Scanner(System.in);
		  guessNum = input.nextInt();
		  if(guessNum < 0 || guessNum > estates.size()) {
			  return -1;
		  }
		  Estate guessedEstate = (Estate) estates.get(guessNum);
		  //guess player
		  System.out.flush();
		  System.out.println("Guess a player 1-" + players.size() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < players.size(); i++) {
			  tmpOutput += i + ")" + players.get(i).getName();
		  }
		  System.out.println(tmpOutput);
		  input = new Scanner(System.in);
		  guessNum = input.nextInt();
		  if(guessNum < 0 || guessNum > players.size()) {
			  return -1;
		  }
		  Player guessedPlayer = players.get(guessNum);
		  //confirm guess
		  System.out.flush();
		  System.out.println("Is this your guess: "  + guessedWeapon.getName() + " " 
				  + guessedEstate.getName() + " " + guessedPlayer.getName() + " y/n?");
		  input = new Scanner(System.in);
		  String answer = input.next();
		  if(!answer.equals("y") || !answer.equals("n")) {
			  return -1;
		  }
		  else if(answer.equals("n")) {
			  return guess(p);
		  }
		  //respond to guess
		  for(int i = 0; i < 3; i++) {
			  p = getNextPlayer(p);
			  if(playerGuessResponse(p, guessedPlayer, guessedWeapon, guessedEstate) != null) {
				  //TODO show guessing player the response
			  }
		  }
	  }
	  return -1;
  }
  /**
   * Method for players to respond to another players guess
   * @param aPlayer
   * @param guessedPlayer
   * @param guessedWeapon
   * @param guessedEstate
   * @return
   */
  private Card playerGuessResponse(Player aPlayer, Player guessedPlayer, Weapon guessedWeapon, Estate guessedEstate) {
	  String output = "";
	  int numCardsToShow = 1;
	  ArrayList<Card> cardsToShow = new ArrayList<Card>();
	  if(aPlayer.getCards().contains(guessedPlayer)) {
		  cardsToShow.add(guessedPlayer);
		  output += numCardsToShow + " " + guessedPlayer.getName();
		  numCardsToShow++;
	  }
	  if(aPlayer.getCards().contains(guessedWeapon)) {
		  cardsToShow.add(guessedWeapon);
		  output += numCardsToShow + " " + guessedWeapon.getName();
		  numCardsToShow++;
	  }
	  if(aPlayer.getCards().contains(guessedEstate)) {
		  cardsToShow.add(guessedEstate);
		  output += numCardsToShow + " " + guessedEstate.getName();
		  numCardsToShow++;
	  }
	  if(numCardsToShow == 1) {
		  System.out.println("No cards to show");
		  Scanner input = new Scanner(System.in);
		  input.next();
		  return null;
	  }
	  while(true) {
		  System.out.flush();
		  System.out.println("Pick a card 1-" + (numCardsToShow-1) + ": ");
		  Scanner input = new Scanner(System.in);
		  int cardToShow = input.nextInt();
		  if(cardToShow < numCardsToShow && cardToShow > 0) {
		  	return cardsToShow.get(cardToShow-1);
		  }
	  }
  }
}