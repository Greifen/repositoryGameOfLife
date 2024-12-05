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
	void testCellStateTransitions(Cell.CellState initialState, int neighbors, Cell.CellState expectedState) {
		Cell cell = new Cell(initialState);
		cell.nextState(neighbors);
		assertEquals(expectedState, cell.getCellState());
	}


	@Test
	void test0Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(0);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test1Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(1);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test4Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(4);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test5Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(5);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test6Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(6);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test7Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(7);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test8Nachbarsterben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(8);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}

	@Test
	void test2NachbarUeberleben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(2);
		assertEquals(Cell.CellState.ALIVE, cell.getCellState());
	}

	@Test
	void test3NachbarUeberleben() {
		Cell cell = new Cell(Cell.CellState.ALIVE);
		cell.nextState(3);
		assertEquals(Cell.CellState.ALIVE, cell.getCellState());
	}

	@Test
	void test3NachbarReproduzieren() {
		Cell cell = new Cell(Cell.CellState.DEAD);
		cell.nextState(3);
		assertEquals(Cell.CellState.ALIVE, cell.getCellState());
	}

	@Test
	void test4NachbarReproduzieren() {
		Cell cell = new Cell(Cell.CellState.DEAD);
		cell.nextState(4);
		assertEquals(Cell.CellState.DEAD, cell.getCellState());
	}
}
