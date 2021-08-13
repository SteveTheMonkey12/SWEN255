import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testMovePlayerStringPlayer() {
		Game testGame = new Game();
		testGame.initial();
		testGame.setNumPlayers(3);
		Position initialPos = testGame.getPlayer_Player(1).getPosition();
		testGame.getBoard().movePlayer("w", testGame.getPlayer_Player(1));
		Position finalPos = null;
		assertEquals(testGame.getPlayer_Player(0).getPosition(), finalPos);
	}

}
