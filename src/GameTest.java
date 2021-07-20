import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void testGuess() {
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
		game.guess(jeff);
		fail();
	}

}
