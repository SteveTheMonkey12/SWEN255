/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 97 "model.ump"
/**
 * @author pengailin
 *
 */
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game State Machines
  public enum Status { Initial, Move, Guess, Solve, End }
  private Status status;

  //Game Do Activity Threads
  Thread doActivityStatusInitialThread = null;

  //Game Associations
  private List<Item> items;
  private Board board;
  private List<Player> players;
  private List<Item> murderCards; // changed to list so can use contains method to check for win
  private List<Weapon> weapons;
  private List<Estate> estates;
  private Player currentPlayer;
  public int numPlayers;

	// name of the 4 characters
	private static final String[] characterName = { "Lucilla", "Bert", "Maline", "Percy" };

	// name of the 5 weapons
	private static final String[] weaponName = { "Broom", "Scissors", "Knife", "Shovel", "iPad" };

	// name of the 5 estate
	private static final String[] estateName = { "Haunted House", "Manic Manor", "Villa Celia", "Calamity Castle",
			"Peril Palace" };

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(Board aBoard)
  {
    items = new ArrayList<Item>();
    if (aBoard == null || aBoard.getGame() != null)
    {
      throw new RuntimeException("Unable to create Game due to aBoard. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    board = aBoard;
    setStatus(Status.Initial);
    players = new ArrayList<Player>();
  }

  public Game()
  {
    items = new ArrayList<Item>();
    board = new Board(this);
    players = new ArrayList<Player>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  private boolean __autotransition392__()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Initial:
        exitStatus();
        setStatus(Status.Move);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean guess()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Move:
        setStatus(Status.Guess);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean cantWin()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Move:
        setStatus(Status.End);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean solve()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Guess:
        setStatus(Status.Solve);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean win()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Solve:
        setStatus(Status.End);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean incorrect()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case Solve:
        // line 32 "model.ump"
        //p.setCanWin(false);
        setStatus(Status.Move);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case Initial:
        if (doActivityStatusInitialThread != null) { doActivityStatusInitialThread.interrupt(); }
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case Initial:
        // line 16 "model.ump"
        initial();
        doActivityStatusInitialThread = new DoActivityThread(this,"doActivityStatusInitial");
        break;
      case Move:
        // line 21 "model.ump"
        play();
        break;
      case Guess:
        // line 26 "model.ump"
        makeGuess();
        break;
      case Solve:
        // line 30 "model.ump"
        solveAttempt();
        break;
    }
  }
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template association_GetMany_clear */
  protected void clear_items()
  {
    items.clear();
  }
  /* Code from template association_GetMany_relatedSpecialization */
  public Player getPlayer_Player(int index)
  {
    Player aPlayer = (Player)players.get(index);
    return aPlayer;
  }

  /* required for Java 7. */
  @SuppressWarnings("unchecked")
  public List<Player> getPlayers_Player()
  {
    List<? extends Item> newPlayers = Collections.unmodifiableList(players);
    return (List<Player>)newPlayers;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    items.add(aItem);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (items.contains(aItem))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }
  public int numberOfPlayers()
  {
    int number = players.size();
    return number;
  }
  /* Code from template association_set_specialization_reqCommonCode */  /* Code from template association_MinimumNumberOfMethod_relatedSpecialization */
  public static int minimumNumberOfPlayers_Player()
  {
    return 3;
  }
  /* Code from template association_MaximumNumberOfMethod_relatedSpecialization */
  public static int maximumNumberOfPlayers_Player()
  {
    return 4;
  }
  /* Code from template association_AddUnidirectionalMN_relatedSpecialization */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    if (numberOfPlayers() < maximumNumberOfPlayers_Player())
    {
      players.add(aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (!players.contains(aPlayer))
    {
      return wasRemoved;
    }

    if (numberOfPlayers() <= minimumNumberOfPlayers_Player())
    {
      return wasRemoved;
    }

    players.remove(aPlayer);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMN_relatedSpecialization */
  public boolean setPlayers(Player... newPlayers)
  {
    boolean wasSet = false;
    ArrayList<Player> verifiedPlayers = new ArrayList<Player>();
    for (Player aPlayer : newPlayers)
    {
      if (verifiedPlayers.contains(aPlayer))
      {
        continue;
      }
      verifiedPlayers.add(aPlayer);
    }

    if (verifiedPlayers.size() != newPlayers.length || verifiedPlayers.size() < minimumNumberOfPlayers_Player() || verifiedPlayers.size() > maximumNumberOfPlayers_Player())
    {
      return wasSet;
    }

    players.clear();
    players.addAll(verifiedPlayers);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions_relatedSpecialization */
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

  private void doActivityStatusInitial()
  {
    try
    {
      // line 17 "model.ump"
      
      Thread.sleep(1);
      __autotransition392__();
    }
    catch (InterruptedException e)
    {

    }
  }

  private static class DoActivityThread extends Thread
  {
    Game controller;
    String doActivityMethodName;
    
    public DoActivityThread(Game aController,String aDoActivityMethodName)
    {
      controller = aController;
      doActivityMethodName = aDoActivityMethodName;
      start();
    }
    
    public void run()
    {
      if ("doActivityStatusInitial".equals(doActivityMethodName))
      {
        controller.doActivityStatusInitial();
      }
    }
  }

  public void delete()
  {
    items.clear();
    Board existingBoard = board;
    board = null;
    if (existingBoard != null)
    {
      existingBoard.delete();
    }
  }

  // line 8 "model.ump"
   public void solveAttempt(){
    
  }

  // line 9 "model.ump"
   public void initial(){
	// initial the cards of estate, character and weapon
	   
			for (int i = 0; i < 4; i++) {
				addItem(new Player(characterName[i]));
			}
			for (int i = 0; i < 5; i++) {
				Weapon tmp = new Weapon(weaponName[i]);
				addItem(tmp);
				weapons.add(new Weapon(weaponName[i]));
				
			}
			for (int i = 0; i < 5; i++) {
				Estate tmp = new Estate(estateName[i], null);
				addItem(tmp);
				estates.add(tmp);
				//TODO add final estate positions
			}
			for(Item i : items) {
				board.addItem(i);
			}
			// randomly choose the murder cards
			Item murderCharacter = players.get((int) (Math.random() * players.size()));
			murderCards.add(murderCharacter);
			items.remove(murderCharacter);
			Item murderWeapon = weapons.get((int) (Math.random() * weapons.size()));
			murderCards.add(murderWeapon);
			items.remove(murderWeapon);
			Item murderEstate = estates.get((int) (Math.random() * estates.size()));
			murderCards.add(murderEstate);
			items.remove(murderEstate);
			
			// distribute cards to player 
			int cardNumbers = items.size() / numPlayers;
			for (int i = 0; i < numPlayers; i++) {
				List<Item> playerCards = new ArrayList<>();
				for (int j = 0; j < cardNumbers; j++) {
					int index = (int) (Math.random() * items.size());
					playerCards.add(items.get(index));
					items.remove(index);
				}
				Player p = new Player(characterName[i], playerCards);
				players.add(p);
				if(i==0) {
					Position position = new Position(11，1);
					p.setPosition(position);
				}else if(i==1){
					Position position = new Position(1，9);
					p.setPosition(position);
				}else if(i==2){
					Position position = new Position(9，22);
					p.setPosition(position);
				}else if(i==3) {
					Position position = new Position(22，14);
					p.setPosition(position);
				}

			}

  }
   
   /*
    * set the number of player according to the input from board
    */
   public void setNumPlayers(int num) {
	   this.numPlayers = num;
   }


	/**
	 * feel free to move it in other methods.
	 * 
	 * @return the result of roll 2 dice
	 */
	public int diceResult() {
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		return dice1 + dice2;
	}

	/**
	 * player moves steps after roll 2 dice cycling around stop play if one player
	 * solve attempt
	 */
	public void play() {
//		while (true) {
//			for (int i = 0; i < players.size(); i++) {
//				System.out.print("\n");
//				System.out.println(players.get(i).getName() + "'s turn:");
//				int steps = diceResult();
//				boolean canMove = true;
//
//				// if the player is in the room, stop moving and check whether the player wants
//				// to guess or solve attempt
//				Position position = board.getPlayerLocation(players.get(i));
//				if (position != null) {
//					Position.Location location = position.getLocation();
//					if (location == Position.Location.HH || location == Position.Location.MM
//							|| location == Position.Location.VC || location == Position.Location.CC
//							|| location == Position.Location.PP) {
//						int result = guess(players.get(i));
//						int attempt = solveAttempt(players.get(i));
//						// stop game when some one win
//						if (attempt == 1) {
//							break;
//						}
//					}
//				}
//
//				// moving steps
//				if (canMove) {
//					for (int j = steps; j >= 1; j--) {
//						System.out.print("you have " + j + " steps to move");
//						String direction = direction();
//						if (board.movePlayer(players.get(i), direction)) {
//							// if the player moves into estate, it will stop moving and start guess/solve
//							// attempt
//							Position p = board.getPlayerLocation(players.get(i));
//							if (position != null) {
//								Position.Location location = p.getLocation();
//								if (location == Position.Location.HH || location == Position.Location.MM
//										|| location == Position.Location.VC || location == Position.Location.CC
//										|| location == Position.Location.PP) {
//									guess(players.get(i));
//									solveAttempt(players.get(i));
//									break;
//								}
//							}
//						}
//						System.out.print(board.toString());
//					}
//				}
//			}
//		}
		
		//TODO add movement
	}

	/**
	 * w: west e: east s: south n: north
	 * 
	 * @return direction of move
	 */
	public String direction() {
		System.out.print("Please enter the direction you want to move (w e s n): ");
		Scanner scan = new Scanner(System.in);
		String direction = scan.next();
		return direction;
	}

  // line 11 "model.ump"
   public int makeGuess(){
	   	Player p = currentPlayer;
	    clearScreen();
		System.out.print(p.getName() + "'s guess y/n\n");
		Scanner input = new Scanner(System.in);
		String guess = input.next();
		if (!guess.equals("y") && !guess.equals("n")) {
			return -1;
		} else if (guess.equals("n")) {
			return 0;
		} else if (guess.equals("y")) {
			clearScreen();
			// guess weapon
			System.out.println("Guess a weapon 1-" + weapons.size() + ":");
			String tmpOutput = "";
			for (int i = 0; i < weapons.size(); i++) {
				tmpOutput += (i + 1) + ") " + weapons.get(i).getName() + "\n";
			}
			System.out.println(tmpOutput);
			int guessNum = input.nextInt() - 1;
			if (guessNum < 0 || guessNum > weapons.size()) {
				return -1;
			}
			Weapon guessedWeapon = (Weapon) weapons.get(guessNum);

			// guess player
			clearScreen();
			System.out.println("Guess a player 1-" + numberOfPlayers() + ":");
			tmpOutput = "";
			for (int i = 0; i < numberOfPlayers(); i++) {
				tmpOutput += (i + 1) + ") " + players.get(i).getName() + "\n";
			}
			System.out.println(tmpOutput);
			guessNum = input.nextInt() - 1;
			if (guessNum < 0 || guessNum > players.size()) {
				return -1;
			}
			Player guessedPlayer = players.get(guessNum);
			// guess estate
			clearScreen();
			//board.moveCharacterTo(guessedPlayer, board.getPlayerLocation(p).getLocation().name);
			//TODO move player to correct square
			Estate guessedEstate = null;
			for (Estate e : estates) {
//				if (e.getName() == board.getPlayerLocation(p).getLocation().name) {
//					guessedEstate = e;
//				}
			}
			if (guessedEstate == null) {
				return -1;
			}
			// confirm guess
			clearScreen();
			System.out.println("Is this your guess: " + guessedWeapon.getName() + " " + guessedEstate.getName() + " "
					+ guessedPlayer.getName() + " y/n?");
			String answer = input.next();
			if (!answer.equals("y") && !answer.equals("n")) {
				return -1;
			} else if (answer.equals("n")) {
				return makeGuess();
			}
			// respond to guess
			Player nextP = p;
			for (int i = 0; i < 3; i++) {
				nextP = getNextPlayer(nextP);
				clearScreen();
				System.out.println(nextP.getName() + "'s turn to response y/n");
				guess = input.next();
				if (!guess.equals("y") && !guess.equals("n")) {
					return -1;
				} else if (guess.equals("n")) {
					return 0;
				} else if (guess.equals("y")) {
					Item response = playerGuessResponse(nextP, guessedPlayer, guessedWeapon, guessedEstate, input);
					if (response != null) {
						clearScreen();
						System.out.println(p.getName() + "'s turn to view response y/n");
						guess = input.next();
						if (!guess.equals("y") && !guess.equals("n")) {
							return -1;
						} else if (guess.equals("n")) {
							return 0;
						} else if (guess.equals("y")) {
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
			if (!guess.equals("y") && !guess.equals("n")) {
				return -1;
			} else if (guess.equals("n")) {
				return 0;
			} else if (guess.equals("y")) {
				System.out.println("No matching response");
			}
		}
		return -1;
	}

	/**
	 * Method for players to respond to another players guess
	 * 
	 * @param aPlayer
	 * @param guessedPlayer
	 * @param guessedWeapon
	 * @param guessedEstate
	 * @return
	 */
	
private Item playerGuessResponse(Player aPlayer, Player guessedPlayer, Weapon guessedWeapon,
		Estate guessedEstate, Scanner input) {
	String output = "";
	int numCardsToShow = 1;
	ArrayList<Item> cardsToShow = new ArrayList<Item>();
	if (aPlayer.getItems().contains(guessedPlayer)) {
		cardsToShow.add(guessedPlayer);
		output += numCardsToShow + " " + guessedPlayer.getName() + " ";
		numCardsToShow++;
	}
	if (aPlayer.getItems().contains(guessedWeapon)) {
		cardsToShow.add(guessedWeapon);
		output += numCardsToShow + " " + guessedWeapon.getName() + " ";
		numCardsToShow++;
	}
	if (aPlayer.getItems().contains(guessedEstate)) {
		cardsToShow.add(guessedEstate);
		output += numCardsToShow + " " + guessedEstate.getName() + " ";
		numCardsToShow++;
	}
	if (numCardsToShow == 1) {
		System.out.println("No cards to show");
		input.next();
		return null;
	}
	while (true) {
		clearScreen();
		System.out.println("Pick a card 1-" + (numCardsToShow - 1) + ": ");
		System.out.println(output);
		int cardToShow = input.nextInt();
		if (cardToShow < numCardsToShow && cardToShow > 0) {
			return cardsToShow.get(cardToShow - 1);
		}
	}
}
   
   public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/**
	 * Method to get the next player in the list
	 * 
	 * @param aPlayer
	 * @return The next player in the list
	 */
	public Player getNextPlayer(Player aPlayer) {
		int index = players.indexOf(aPlayer);
		if (index == numberOfPlayers() - 1) {
			index = 0;
		} else {
			index++;
		}
		return players.get(index);
	}
	
	public void nextTurn() {
		currentPlayer = getNextPlayer(currentPlayer);
	}

  // line 12 "model.ump"
   public void solveAttempt(Player p){
    
  }

    public List<Player> getPlayers() {
	  return players;
   }

	public List<Weapon> getWeapons() {
		return weapons;
	}


}
