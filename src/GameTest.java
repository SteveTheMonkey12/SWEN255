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
															
		//System.setIn(in);
		
		Game game = new Game();
		game.initial();
		//System.setIn(sysInBackup);
		//assertTrue(output == 1);
	}

}
