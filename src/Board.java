/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.0.5692.1a9e80997 modeling language!*/

import java.util.*;



public class Board
{
	
	

  //------------------------
  // MEMBER VARIABLES
  //------------------------


  //Board Associations
  
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
    for(Player p: players) {
    	if(p.getName().equals("Lucilla")) {
    		playerPositions.put(p, new Position(11, 1, null));
    	}else if(p.getName().equals("Bert")) {
    		playerPositions.put(p, new Position(1, 9, null));
    	}else if(p.getName().equals("Maline")) {
    		playerPositions.put(p, new Position(22, 14, null));
    	}else if(p.getName().equals("Percy")) {
    		playerPositions.put(p, new Position(9, 22, null));
    	}else {
    		playerPositions.put(p, new Position(0, 0, Position.Location.CC));
    	}
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  // line 11 "model.ump"
   public Position getPlayerLocation(Player target){
    return this.playerPositions.get(target);
  }
  public boolean movePlayerTo(Player target, String destinationName) {
	  for(Position.Location p: Position.Location.values()) {
		  if(destinationName.equals(p.name)) {
			  playerPositions.put(target, new Position(0, 0, p));
			  return true;
		  }
	  }
	  return false;
	  
  }

  public boolean movePlayerTo(Player target, String destinationName) {
	  for(Position.Location p: Position.Location.values()) {
		  if(destinationName.equals(p.name)) {
			  playerPositions.put(target, new Position(0, 0, p));
			  return true;
		  }
	  }
	  return false;
	  
  }


  // line 15 "model.ump"
   public boolean movePlayer(Player target, String cardinalDirection){
	   //is the player in a house?
	   Position currentPos = playerPositions.get(target);
	   Position newPos;

	   //if they have a location move them to the doorway the intend to leave via and then continue with the validity checking
	   if(currentPos.getLocation() != null) {
		   switch(cardinalDirection) {
		   case "n":
			   currentPos = currentPos.getLocation().n;
			   break;
		   case "s":
			   currentPos = currentPos.getLocation().s;
			   break;
		   case "e":
			   currentPos = currentPos.getLocation().e;
			   break;
		   case "w":
			   currentPos = currentPos.getLocation().w;
			   break;
			default:
				return false;
		   }
		   if(currentPos == null) {
			   return false;
		   }
	   }
	   
	   //Find their new co-ordinates

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
	   

	   boolean enteredDoor = false;
	   //Check if going into door
	   for(Position.Location l: Position.Location.values()) {
		   if(newPos.equals(l.n)) {
			   newPos = new Position(0, 0, l);
			   enteredDoor = true;
			   break;
		   }else if(newPos.equals(l.e)) {
			   newPos = new Position(0, 0, l);
			   enteredDoor = true;
			   break;
		   }else if(newPos.equals(l.s)) {
			   newPos = new Position(0, 0, l);
			   enteredDoor = true;
			   break;
		   }else if(newPos.equals(l.w)) {
			   newPos = new Position(0, 0, l);
			   enteredDoor = true;
			   break;
		   }
	   }
	   if(enteredDoor) {
		   this.playerPositions.put(target, newPos);
		   return true;

	   }
	   

	   
	   //check if walking into wall
	   for(Position.Location l: Position.Location.values()) {
		   if(newPos.getX() >= l.x1 && newPos.getY() >= l.y1 && newPos.getX() <= l.x2 && newPos.getY() <= l.y2 ) {
			   return false;
		   }
	   }

	   //check if walking into another player
	   for(Player p: this.players) {
		   if(p.getName().equals(target.getName())) {
			   continue;
		   }
		   if(this.playerPositions.get(p).equals(newPos) && this.playerPositions.get(target).getLocation() == null) {
			   return false;
		   }
	   }
	   
	   this.playerPositions.put(target, newPos);
	   return true;
  }

  // line 19 "model.ump"
   public String toString(){

	   String[][] board = new String[24][24];
	   String output = new String("");
	   
	   //Fill board with grid
	   for(int y = 0; y < 24; y++) {
		   for(int x = 0; x < 24; x++) {
			   board[x][y] = "|_";
		   }
	   }
	   int playersInRoom = 0;
	   //Draw Rooms
	   for(Position.Location room: Position.Location.values()) {
		   //Draw the left hand side
		   for(int y = room.y1; y <= room.y2; y++) {
			   board[room.x1][y] = "|*";
		   }
		   //Draw right hand side
		   for(int y = room.y1; y <= room.y2; y++) {
			   board[room.x2][y] = " *";
		   }
		   //Draw the top and Bottom
		   for(int x = room.x1 + 1; x <= room.x2; x++) {
			   board[x][room.y1] = "**";
			   board[x][room.y2] = "**";
		   }
		   //Draw Middle
		   for(int y = room.y1 + 1; y < room.y2; y++) {
			   for(int x = room.x1 + 1; x <  room.x2; x++) {
				   board[x][y] = "  ";
				   board[x][y] = "  ";
			   }
		   }
		   //Draw Labels
		   board[room.x1 + 2][room.y1 + 1] = room.toString();
		   
		   //Draw Players in room
		   playersInRoom = 0;
		   for (Map.Entry<Player, Position> entry : this.playerPositions.entrySet()) {
			   	
			    entry.getKey();
			    entry.getValue();
			    if(room.equals(entry.getValue().getLocation())) {
			    	//if the player is in this room then draw them along the bottom
			    	board[room.x1 + 1 + playersInRoom][room.y2 - 2] = entry.getKey().getName().split("")[0] + " ";
			    	playersInRoom++;
			    	
			    }
			}
		   //Draw doors
		   //Draw Bottom doors
		   if(room.n != null) {
			   board[room.n.getX()][room.n.getY()] = "  ";
		   }
		   if(room.e != null) {
			   board[room.e.getX()][room.e.getY()] = "  ";
		   }
		   if(room.s != null) {
			   board[room.s.getX()][room.s.getY()] = "  ";
		   }
		   if(room.w != null) {
			   board[room.w.getX()][room.w.getY()] = "  ";
		   }
		   
		   
	   }
	   //Draw the players
	   for (Map.Entry<Player, Position> entry : this.playerPositions.entrySet()) {
		   	
		    entry.getKey();
		    entry.getValue();
		    if(entry.getValue().getLocation() == null) {
		    	board[entry.getValue().getX()][entry.getValue().getY()] = "|" + entry.getKey().getName().substring(0, 1);
		    }
		    
		}
	   
	   
	   //render board
	   output = "_________________________________________________\n";
	   for(int y = 0; y < 24; y++) {
		   for(int x = 0; x < 24; x++) {
			   output += board[x][y];
		   }
		   output += "|\n";
	   }
	   
	   return output;
  }

}
