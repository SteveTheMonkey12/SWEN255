import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testGuess() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream(("y" + System.lineSeparator()   //Jeff guess?
															+ "1" + System.lineSeparator() //weapon select
															+ "1" + System.lineSeparator() //estate select
															+ "1" + System.lineSeparator() //player select
															+ "y" + System.lineSeparator() //confirm guess
															+ "y" + System.lineSeparator() //Steve respond?
															+ "1" + System.lineSeparator() //Select card to respond with
															+ "y" + System.lineSeparator() //Jeff to view response
															+ "y" + System.lineSeparator() //Continue game
															).getBytes()); 
															
		System.setIn(in);

		Game game = new Game(null);
		Player steve = new Player("Steve");
		Player jeff = new Player("Jeff");
		game.addPlayer(steve);
		game.addPlayer(jeff);
		Weapon spade = new Weapon("Spade");
		Weapon trout = new Weapon("Trout");
		Estate vic = new Estate("Vic");
		Estate wellington = new Estate("Wellington");
		steve.addCard(spade);
		game.addWeapon(spade);
		jeff.addCard(trout);
		game.addWeapon(trout);
		steve.addCard(vic);
		game.addEstate(vic);
		jeff.addCard(wellington);
		game.addEstate(wellington);
		steve.addCard(jeff);
		jeff.addCard(steve);
		int output = game.guess(jeff);
		System.setIn(sysInBackup);
		assertTrue(output == 1);
	}

}
