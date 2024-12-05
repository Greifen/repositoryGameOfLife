import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CellTest {

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

	@ParameterizedTest
	@CsvSource({
			// Sterben: zu wenig Nachbarn
			"ALIVE, 0, DEAD", "ALIVE, 1, DEAD",
			// Sterben: zu viele Nachbarn
			"ALIVE, 4, DEAD", "ALIVE, 5, DEAD", "ALIVE, 6, DEAD", "ALIVE, 7, DEAD", "ALIVE, 8, DEAD",
			// Überleben
			"ALIVE, 2, ALIVE", "ALIVE, 3, ALIVE",
			// Reproduktion
			"DEAD, 3, ALIVE",
			// Kein Reproduzieren
			"ALIVE, 0, DEAD", "ALIVE, 1, DEAD", "ALIVE, 2, ALIVE", "DEAD, 4, DEAD", "ALIVE, 5, DEAD", "ALIVE, 6, DEAD",
			"ALIVE, 7, DEAD", "ALIVE, 8, DEAD" })
	void testNextState(Cell.CellState initialState, int neighbors, Cell.CellState expectedState) {
		Cell cell = new Cell(initialState);
		cell.nextState(neighbors);
		assertEquals(expectedState, cell.getCellState());
	}
}
