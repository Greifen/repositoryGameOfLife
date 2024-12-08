import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class UniverseTest {

	/**
	 * Die Zelle ist tot.
	 */
	private static final Cell.CellState O = Cell.CellState.DEAD;
	/**
	 * Die Zelle ist am Leben.
	 */
	private static final Cell.CellState X = Cell.CellState.ALIVE;

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
	void testStoreInitialState() {
		assertArrayEquals(new Universe(new Cell.CellState[][] {
			{X, X, X},
			{O, X, X},
			{X, X, O}
		}).getState(),new Cell.CellState[][] {
			{X, X, X},
			{O, X, X},
			{X, X, O}
		});
	}

}
