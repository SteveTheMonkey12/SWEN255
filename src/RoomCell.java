public class Room implements Cell{
	private boolean cellOccupied = false; //is another player in this cell?
	private final Position position;
	private Player player = null; //who is in this cell
	
	public Room(Position p) {
		this.position = p;
	}
	
	/*place player in cell*/
	public void setPlayer(Player p) {
		player = p;
		cellOccupied = true;
	}
	
	/*Remove player from this cell*/
	public void removePlayer() {
		player = null;
		cellOccupied = false;
	}

	/*returns true if a player isn't in cell*/
	public boolean accessAllowed() {
		return cellOccupied;
	}

	public Position getPosition() {
		return position;
	}
	
	public String toString() {
		if(cellOccupied && player!=null) {return player.toString();}//player
		return "R";
	}	
}
