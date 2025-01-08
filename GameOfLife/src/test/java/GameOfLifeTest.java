import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static Cell.CellState.*;

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
		Game<Void> uut = new GameOfLife(universe, null);
		
		uut.update(null);
		
		verify(universe).nextState();

	}
	
	
	@Test
	void isAlwaysRunning() {
		GameOfLife uut = new GameOfLife(null, null);
		
		assertTrue(uut.isRunning());
	}

/*	@Test
	public void printsInitialGameStateToConsole() {
		Universe universe = new OriginalGameOfLifeUniverse(
				new Cell.CellState[][] { { X, O, X }, { O, X, X }, { X, X, O } });
		Game<Void> game = new GameOfLife(universe);
		game.render();
	}*/
	
	@Test
	public void printsDeadCellInitialGameStateToConsole() {
		Universe universe = mock(Universe.class);
		when(universe.getState()).thenReturn(new Cell.CellState[][] {
			{Cell.CellState.DEAD}
		});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GameOfLife uut = new GameOfLife(universe, new PrintStream(out));
		
		uut.render();
		
		String output = new String(out.toByteArray());
		assertEquals(
				"+-+\n"
				+"|O|\n"
				+"+-+\n",
				output);
	}
}
