/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/
package Java;

import java.util.*;

// line 8 "model.ump"
// line 73 "model.ump"
public class Board
{
	
	

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Player p = new Player("Simon", true);
		players.add(p);
		
		Board b = new Board(players);
		
		System.out.println(b.movePlayer(p, "e"));
		System.out.println(b.movePlayer(p, "e"));
		System.out.println(b.movePlayer(p, "n"));
		System.out.println(b.movePlayer(p, "n"));
		System.out.println(b.movePlayer(p, "n"));
		System.out.println(b.movePlayer(p, "n"));
		
		

	}
  private List<Player> players;

  private HashMap<Player, Position> playerPositions;
  

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(ArrayList<Player> players)
  {
    this.playerPositions = new HashMap<Player, Position>();
    this.players = players;
    
    //Put all the players in a row along the top for now
    for(int i = 0; i < players.size(); i++) {
    	playerPositions.put(players.get(i), new Position(i, 10, null));
    }
  }

  //------------------------
  // INTERFACE
  //------------------------


  // line 11 "model.ump"
   public Position getPlayerLocation(Player target){
    return this.playerPositions.get(target);
  }

  // line 15 "model.ump"
   public boolean movePlayer(Player target, String cardinalDirection){
	   //is the player in a house?
	   Position currentPos = playerPositions.get(target);
	   Position newPos;
	   if(currentPos.getLocation() != null) {
		   //they're in a house
		   return false;
	   }
	   
	   //if they're not in a house find their new co-ordinates
	   switch(cardinalDirection) {
	   case "n":
		   newPos = new Position(currentPos.getX(), currentPos.getY() - 1, null);
		   break;
	   case "s":
		   newPos = new Position(currentPos.getX(), currentPos.getY() + 1, null);
		   break;
	   case "e":
		   newPos = new Position(currentPos.getX() + 1, currentPos.getY(), null);
		   break;
	   case "w":
		   newPos = new Position(currentPos.getX() - 1, currentPos.getY(), null);
		   break;
		default:
			return false;
	   
	   }
	   
	   //Check out of bounds
	   if(newPos.getX() < 0 ||  23 < newPos.getX() || newPos.getY() < 0 || 23 < newPos.getY()) {
		   return false;
	   }
	   
	   
	   //Check if going into door
	   
	   
	   //check if walking into wall
	   for(Position.Location l: Position.Location.values()) {
		   if(newPos.getX() >= l.x1 && newPos.getY() >= l.y1 && newPos.getX() <= l.x2 && newPos.getY() <= l.y2 ) {
			   return false;
		   }
	   }
	   this.playerPositions.put(target, newPos);
	   return true;
  }

  // line 19 "model.ump"
   public String toString(){
    return "";
  }

}