public class Block implements Cell {
	private final Position position;
	
	public Block(Position p) {
		this.position = p;
	}
	
	/*no player can enter block*/
	public boolean accessAllowed() {
		return false;
	}

	public String toString() {
		return "X";
	}

	public Position getPosition() {
		return position;
	}
	
}
