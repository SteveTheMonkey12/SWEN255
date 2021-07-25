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

  //Game Associations
  private List<Player> players;
  private Board board;
  private List<Weapon> weapons;
  private List<Estate> estates;
  private List<Card> cards;
  private List<Character> characters;
  private List<Card> murderCards; //changed to list so can use contains method to check for win
  
  //name of the 4 characters
  private static final String[] characterName = {"Lucilla", "Bert", "Maline", "Percy"};
  
  //name of the 5 weapons
  private static final String[] weaponName = {"Broom","Scissors","Knife","Shovel","iPad"};
  
  //name of the 5 estate
  private static final String[] estateName = {"Haunted House", "Manic Manor", "Villa Celia", "Calamity Castle","Peril Palace"};

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game()
  {

    players = new ArrayList<Player>();
    cards = new ArrayList<Card>();
    weapons = new ArrayList<Weapon>();
    estates = new ArrayList<Estate>();
    characters = new ArrayList<Character>();
    murderCards = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  
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
  public Character getCharacter(int index)
  {
    Character aCharacter = characters.get(index);
    return aCharacter;
  }

  public List<Character> getCharacters()
  {
    List<Character> newCharacters = Collections.unmodifiableList(characters);
    return newCharacters;
  }

  public int numberOfCharacters()
  {
    int number = characters.size();
    return number;
  }

  public boolean hasCharacters()
  {
    boolean has = characters.size() > 0;
    return has;
  }

  public int indexOfCharacter(Character aCharacter)
  {
    int index = characters.indexOf(aCharacter);
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
  public static int minimumNumberOfCharacters()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCharacter(Character aCharacter)
  {
    boolean wasAdded = false;
    if (characters.contains(aCharacter)) { return false; }
    characters.add(aCharacter);
    if (aCharacter.indexOfGame(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCharacter.addGame(this);
      if (!wasAdded)
      {
        characters.remove(aCharacter);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeCharacter(Character aCharacter)
  {
    boolean wasRemoved = false;
    if (!characters.contains(aCharacter))
    {
      return wasRemoved;
    }

    int oldIndex = characters.indexOf(aCharacter);
    characters.remove(oldIndex);
    if (aCharacter.indexOfGame(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCharacter.removeGame(this);
      if (!wasRemoved)
      {
        characters.add(oldIndex,aCharacter);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCharacterAt(Character aCharacter, int index)
  {  
    boolean wasAdded = false;
    if(addCharacter(aCharacter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCharacters()) { index = numberOfCharacters() - 1; }
      characters.remove(aCharacter);
      characters.add(index, aCharacter);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCharacterAt(Character aCharacter, int index)
  {
    boolean wasAdded = false;
    if(characters.contains(aCharacter))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCharacters()) { index = numberOfCharacters() - 1; }
      characters.remove(aCharacter);
      characters.add(index, aCharacter);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCharacterAt(aCharacter, index);
    }
    return wasAdded;
  }
  
  /* Code from template association_AddManyToManyMethod */
  public boolean addPlayer(Player aPlayer)
  {
    if (players.contains(aPlayer)) { return false; }
    players.add(aPlayer);
    return true;
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
    return true;
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
  public static int minimumNumberOfBoards()
  {
    return 0;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setBoard(Board aNewBoard)
  {
    boolean wasSet = false;
    if (aNewBoard != null)
    {
      board = aNewBoard;
      wasSet = true;
    }
    return wasSet;
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
    weapons.clear();
    players.clear();
    estates.clear();
    ArrayList<Player> copyOfPlayers = new ArrayList<Player>(players);
    players.clear();
    board = null;
    cards.clear();
  }
  
  //Elliott's guess stuff
  
  public static void clearScreen() {
	  System.out.print("\033[H\033[2J");  
	  System.out.flush();  
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


  /**
   * Starts the guessing sequence from a given player
   * @param p the player that is having a guess
   * @return -1 if bad input, 0 if no guess, 1 if guess
   */

  public int guess(Player p) {
	  clearScreen();
	  System.out.print(p.getName() + "'s guess y/n\n");
	  Scanner input = new Scanner(System.in);
	  String guess = input.next();
	  if(!guess.equals("y") && !guess.equals("n")) {
		  return -1;
	  }
	  else if(guess.equals("n")) {
		  return 0;
	  }
	  else if(guess.equals("y")) {
		  clearScreen();
		  //guess weapon
		  System.out.println("Guess a weapon 1-" + numberOfWeapons() + ":");
		  String tmpOutput = "";
		  for(int i = 0; i < numberOfWeapons(); i++) {
			  tmpOutput += (i+1) + ") " + getWeapon(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  int guessNum = input.nextInt() -1;
		  if(guessNum < 0 || guessNum > numberOfWeapons()) {
			  return -1;
		  }
		  Weapon guessedWeapon = (Weapon) getWeapon(guessNum);
		  //guess estate
		  clearScreen();
		  System.out.println("Guess an Estate 1-" + numberOfEstates() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < numberOfEstates(); i++) {
			  tmpOutput += (i+1) + ") " + getEstate(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  guessNum = input.nextInt() -1;
		  if(guessNum < 0 || guessNum > numberOfEstates()) {
			  return -1;
		  }
		  Estate guessedEstate = (Estate) getEstate(guessNum);
		  //guess player
		  clearScreen();
		  System.out.println("Guess a player 1-" + numberOfPlayers() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < numberOfPlayers(); i++) {
			  tmpOutput += (i+1) + ") " + getCharacter(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  guessNum = input.nextInt()-1;
		  if(guessNum < 0 || guessNum > numberOfCharacters()) {
			  return -1;
		  }
		  Character guessedPlayer = getCharacter(guessNum);
		  //confirm guess
		  clearScreen();
		  System.out.println("Is this your guess: "  + guessedWeapon.getName() + " " 
				  + guessedEstate.getName() + " " + guessedPlayer.getName() + " y/n?");
		  String answer = input.next();
		  if(!answer.equals("y") && !answer.equals("n")) {
			  return -1;
		  }
		  else if(answer.equals("n")) {
			  return guess(p);
		  }
		  //respond to guess
		  Player nextP = p;
		  for(int i = 0; i < 3; i++) {
			  nextP = getNextPlayer(nextP);
			  clearScreen();
			  System.out.println(nextP.getName() + "'s turn to response y/n");
			  guess = input.next();
			  if(!guess.equals("y") && !guess.equals("n")) {
				  return -1;
			  }
			  else if(guess.equals("n")) {
				  return 0;
			  }
			  else if(guess.equals("y")) {
				  Card response = playerGuessResponse(nextP, guessedPlayer, guessedWeapon, guessedEstate, input);
				  if(response != null) {
					  clearScreen();
					  System.out.println(p.getName() + "'s turn to view response y/n");
					  guess = input.next();
					  if(!guess.equals("y") && !guess.equals("n")) {
						  return -1;
					  }
					  else if(guess.equals("n")) {
						  return 0;
					  }
					  else if(guess.equals("y")) {
						  System.out.println(response.getName());
						  System.out.println("Press y to continue: ");
						  input.next();
						  return 1;
					  }
				  }
			  }
		  }
		  clearScreen();
		  System.out.print(nextP.getName() + "'s response y/n\n");
		  guess = input.next();
		  if(!guess.equals("y") && !guess.equals("n")) {
			  return -1;
		  }
		  else if(guess.equals("n")) {
			  return 0;
		  }
		  else if(guess.equals("y")) {
			  System.out.println("No matching response");
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
  private Card playerGuessResponse(Player aPlayer, Character guessedPlayer, Weapon guessedWeapon, Estate guessedEstate, Scanner input) {
	  String output = "";
	  int numCardsToShow = 1;
	  ArrayList<Card> cardsToShow = new ArrayList<Card>();
	  if(aPlayer.getCards().contains(guessedPlayer)) {
		  cardsToShow.add(guessedPlayer);
		  output += numCardsToShow + " " + guessedPlayer.getName() + " ";
		  numCardsToShow++;
	  }
	  if(aPlayer.getCards().contains(guessedWeapon)) {
		  cardsToShow.add(guessedWeapon);
		  output += numCardsToShow + " " + guessedWeapon.getName() + " ";
		  numCardsToShow++;
	  }
	  if(aPlayer.getCards().contains(guessedEstate)) {
		  cardsToShow.add(guessedEstate);
		  output += numCardsToShow + " " + guessedEstate.getName() + " ";
		  numCardsToShow++;
	  }
	  if(numCardsToShow == 1) {
		  System.out.println("No cards to show");
		  input.next();
		  return null;
	  }
	  while(true) {
		  clearScreen();
		  System.out.println("Pick a card 1-" + (numCardsToShow-1) + ": ");
		  System.out.println(output);
		  int cardToShow = input.nextInt();
		  if(cardToShow < numCardsToShow && cardToShow > 0) {
		  	return cardsToShow.get(cardToShow-1);
		  }
	  }
  }
  
  /**
   * initial the cards of estate, character and weapon.
   * randomly choose the murder cards.
   * distribute cards to player
   * load board
   */
  public void initial() {
	  
	  //initial the cards of estate, character and weapon
	  for(int i = 0; i<4 ;i++) {
		  characters.add(new Character(characterName[i]));
		  cards.add(new Character(characterName[i]));
	  }
	  for(int i = 0; i<5; i++) {
		  weapons.add(new Weapon(weaponName[i]));
		  cards.add(new Weapon(weaponName[i]));
		  estates.add(new Estate(estateName[i]));
		  cards.add(new Estate(estateName[i]));
	  }
	  
	  //randomly choose the murder cards
	  Card murderCharacter = characters.get((int) (Math.random() * characters.size()));
	  murderCards.add(murderCharacter);
	  cards.remove(murderCharacter);
	  Card murderWeapon = weapons.get((int) (Math.random() * weapons.size()));
	  murderCards.add(murderWeapon);
	  cards.remove(murderWeapon);
      Card murderEstate = estates.get((int) (Math.random() * estates.size()));
      murderCards.add(murderEstate);
      cards.remove(murderEstate);
      
      //distribute cards to player
      System.out.print("Number of players? 3 or 4 players?");
      int playerNumbers = getNumber();
      int cardNumbers = cards.size()/ playerNumbers;
      for(int i =0; i<playerNumbers; i++) {
    	  List<Card> playerCards = new ArrayList<>();
    	  for(int j=0; j<cardNumbers; j++) {
    		  int index = (int) (Math.random() * cards.size());
    		  playerCards.add(cards.get(index));
    		  cards.remove(index);
    	  }
    	  players.add(new Player(characterName[i],playerCards, characters.get(i)));
    	    
      }
      //load initial board
      board = new Board(players);
      System.out.print(board.toString());
  
  }
  
  /**
   * 
   * @param w The guessed weapon
   * @param e The guessed estate
   * @param c The guessed character
   * @return  -1 if no solve, 0 if incorrect solve, 1 if solved
   */
  private int solveAttempt(Player p) {
	  clearScreen();
	  System.out.print(p.getName() + "'s solve attempt? y/n\n");
	  Scanner input = new Scanner(System.in);
	  String guess = input.next();
	  if(!guess.equals("y") && !guess.equals("n")) {
		  return -1;
	  }
	  else if(guess.equals("n")) {
		  return 0;
	  }
	  else if(guess.equals("y")) {
		  if(p.isCanWin()) {
			  System.out.println(p.getName() + " has already tried to solve");
			  return -1;
		  }
		  clearScreen();
		  //guess weapon
		  System.out.println("Guess a weapon 1-" + numberOfWeapons() + ":");
		  String tmpOutput = "";
		  for(int i = 0; i < numberOfWeapons(); i++) {
			  tmpOutput += (i+1) + ") " + getWeapon(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  int guessNum = input.nextInt() -1;
		  if(guessNum < 0 || guessNum > numberOfWeapons()) {
			  return -1;
		  }
		  Weapon guessedWeapon = (Weapon) getWeapon(guessNum);
		  //guess estate
		  clearScreen();
		  System.out.println("Guess an Estate 1-" + numberOfEstates() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < numberOfEstates(); i++) {
			  tmpOutput += (i+1) + ") " + getEstate(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  guessNum = input.nextInt() -1;
		  if(guessNum < 0 || guessNum > numberOfEstates()) {
			  return -1;
		  }
		  Estate guessedEstate = (Estate) getEstate(guessNum);
		  //guess player
		  clearScreen();
		  System.out.println("Guess a player 1-" + numberOfPlayers() + ":");
		  tmpOutput = "";
		  for(int i = 0; i < numberOfPlayers(); i++) {
			  tmpOutput += (i+1) + ") " + getCharacter(i).getName() + "\n";
		  }
		  System.out.println(tmpOutput);
		  guessNum = input.nextInt()-1;
		  if(guessNum < 0 || guessNum > numberOfCharacters()) {
			  return -1;
		  }
		  Character guessedPlayer = getCharacter(guessNum);
		  //confirm guess
		  clearScreen();
		  System.out.println("Is this your guess: "  + guessedWeapon.getName() + " " 
				  + guessedEstate.getName() + " " + guessedPlayer.getName() + " y/n?");
		  String answer = input.next();
		  if(!answer.equals("y") && !answer.equals("n")) {
			  return -1;
		  }
		  else if(answer.equals("n")) {
			  return guess(p);
		  }
		  if(murderCards.contains(guessedWeapon) && murderCards.contains(guessedEstate) && murderCards.contains(guessedPlayer)) {
			  System.out.println(p.getName() + " wins!!!");
			  return 1;
		  }
		  else {
			  System.out.println(p.getName() + " is incorrect :(");
			  p.setCanWin(false);
			  return 0;
		  }
	  }
	  
	  
	  return 0;
  }
  /**
   * 
   * @return the number from system input
   */
  private int getNumber() {
	  int num = 0;
      try {
          Scanner scan = new Scanner(System.in);
          num = scan.nextInt();
      }catch(java.util.InputMismatchException e) {
      }
	return num;
}

/**
   * feel free to move it in other methods.
   * @return the result of roll 2 dice
   */
  public int diceResult() {
	  int dice1 = (int) (Math.random() * 6) + 1;
	  int dice2 = (int) (Math.random() * 6) + 1;
	  return dice1+dice2;
  }
  
  /**
   * player moves steps after roll 2 dice
   * cycling around
   * stop play if one player solve attempt
   */
  public void play() {
	  for(int i =0; i< players.size(); i++) {
		  System.out.print("\n");
		  System.out.println(players.get(i).getName() + "'s turn");
		  int steps = diceResult();
		  boolean canMove = true;
		  //if the player is in the room, stop moving and check whether the player wants to guess or solve attempt
		  Position.Location location = board.getPlayerLocation(players.get(i)).getLocation(); 
		  //location returns null when not in a location
//		  if(location.equals("Haunted House")||
//				  location.equals("Manic Manor")||
//				  location.equals("Villa Celia")||
//				  location.equals("Calamity Castle")||
//				  location.equals("Peril Palace")) {
//			  
//
//		  }
		  if(location != null) {
			  
		  }
		  //moving steps
		  if(canMove) {
			 for(int j = steps; j>=1; j--) {
				 System.out.print("you have " +steps+" steps to move");
				 String direction = direction();
				 board.movePlayer(players.get(i),direction);	 
			 }
				 
			 
		  }
		  
	  }
	  
  }
  
  /**
   * w: west
   * e: east
   * s: south
   * n: north
   * @return direction of move
   */
  public String direction(){
      System.out.print("Please enter the direction you want to move (w e s n): ");
      Scanner scan = new Scanner(System.in);
      String direction = scan.next();
      return direction;
  }
  
  /**
   * the main method for running the game
   * @param args
   */
  public static void main(String args[]) {
	  Game game = new Game();
	  game.initial();
	  game.play();
	  
  }
  
  
  

}