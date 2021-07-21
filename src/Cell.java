public interface Cell{

/*Is player allowed to move to this cell*/
public boolean accessAllowed();

public Position getPosition();

/*representation on the board*/
public String toString();

}
