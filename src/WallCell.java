public class Wall implements Cell{
	/*One wall takes up a whole cell*/
	private final Position position;
	
	public Wall(Position p) {
		this.position = p;
	}
	
	public boolean accessAllowed() {
		return false;
	}

	public Position getPosition() {
		return position;
	}
	
	public String toString() {
		return "W";
	}

}
