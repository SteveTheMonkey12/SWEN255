package Java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class boardTest {
	
	@Test public void test_01() {

		//One player Moving into a building and exiting
		ArrayList<Player> players = new ArrayList<Player>();
		Player p = new Player("Simon", true);
		
		players.add(p);

		
		Board b = new Board(players);
		
		
		String moves = "nnneeeee";
		for(String s: moves.split("")) {
			b.movePlayer(p, s);

		}
		assertTrue(b.movePlayer(p, "n"));
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |_|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*S      *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
		
		//And Exiting building
		assertTrue(b.movePlayer(p, "e"));
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |S|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
	}
	@Test public void test_02() {
		//Player Collisions
		ArrayList<Player> players = new ArrayList<Player>();
		Player p = new Player("Simon", true);
		Player p2 = new Player("Pimon", true);
		
		players.add(p);
		players.add(p2);

		
		Board b = new Board(players);
		
		
		String moves = "";
		for(String s: moves.split("")) {
			b.movePlayer(p, s);

		}
		
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |_|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|S|P|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
		assertFalse(b.movePlayer(p2, "w"));
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |_|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|S|P|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
	}
	@Test public void test_03() {

		//2 players in a building
		ArrayList<Player> players = new ArrayList<Player>();
		Player p = new Player("Simon", true);
		Player p2 = new Player("Pimon", true);
		
		players.add(p);
		players.add(p2);


		
		Board b = new Board(players);
		
		
		String moves = "nnneeee";
		for(String s: moves.split("")) {
			b.movePlayer(p2, s);
			b.movePlayer(p, s);

		}
		b.movePlayer(p2, "n");
		b.movePlayer(p, "e");
		assertTrue(b.movePlayer(p, "n"));
		
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |_|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*S P    *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
		
		//And Exiting building
		assertTrue(b.movePlayer(p, "e"));
		assertEquals("_________________________________________________\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|*  HH    |S|_|_|_|_|_|_|_|_|_|*  MM   *|_|_|\n"
				+ "|_|_|*P      *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*****  **|_|_|_|_|_|_|_|_|_|_|*****  **|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*****  ****|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|*  VC      |_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_           *|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|***  ******|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|*  ******|_|_|_|_|_|_|_|_|_|_|*  ******|_|_|\n"
				+ "|_|_|*  CC    |_|_|_|_|_|_|_|_|_|_|*  PP   *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_|*       *|_|_|\n"
				+ "|_|_|*       *|_|_|_|_|_|_|_|_|_|_         *|_|_|\n"
				+ "|_|_|*********|_|_|_|_|_|_|_|_|_|_|*********|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n"
				+ "|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|\n", b.toString());
	}
}
