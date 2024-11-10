import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	

}
