import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameloop.Game;

class GameOfLifeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void invokesUpdateOfTheUniverse() {
		Universe universe = mock(Universe.class);
		Game<Void> uut = new GameOfLife(universe);
		
		uut.update(null);
		
		verify(universe).nextState();

	}
	
	
	@Test
	void isAlwaysRunning() {
		GameOfLife uut = new GameOfLife(null);
		
		assertTrue(uut.isRunning());
	}

}
