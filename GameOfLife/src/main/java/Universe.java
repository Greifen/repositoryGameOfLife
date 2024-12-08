
public class Universe {

	private Cell[][] state;

	public Universe(Cell.CellState[][] cellStates) {
		state = new Cell[cellStates.length][];

		for (int i = 0; i < cellStates.length; i++) { // Iterating through rows
			state[i] = new Cell[cellStates[i].length];

			for (int j = 0; j < cellStates[i].length; j++) { // Iterating through columns
				state[i][j] = new Cell(cellStates[i][j]);
			}
		}

	}

	public Cell.CellState[][] getState() {
		Cell.CellState[][] stateR = new Cell.CellState[state.length][];

		for (int i = 0; i < state.length; i++) { // Iterating through rows
			stateR[i] = new Cell.CellState[state[i].length];

			for (int j = 0; j < state[i].length; j++) { // Iterating through columns
				stateR[i][j] = state[i][j].getCellState();
			}
		}
		return stateR;
	}

	public void nextState() {
		Cell.CellState[][] copyCellStates = getState();

		Cell.CellState[][] stateR = new Cell.CellState[state.length][];

		for (int i = 0; i < state.length; i++) { // Iterating through rows
			stateR[i] = new Cell.CellState[state[i].length];

			for (int j = 0; j < state[i].length; j++) { // Iterating through columns

				state[i][j].nextState(neighbours(copyCellStates, i, j));
				stateR[i][j] = state[i][j].getCellState();
			}
		}
	}

	private int neighbours(Cell.CellState[][] state, int row, int column) {
		int neighbours = 0;

		// obere Zeile
		if (row > 0) {
			neighbours += neighboursInRow(state, row - 1, column);
		}

		// mittlere Zeile
		neighbours += neighboursInCell(state, row, column - 1);
		neighbours += neighboursInCell(state, row, column + 1);

		// untere Zeile
		if (row < state.length - 1) {
			neighbours += neighboursInRow(state, row + 1, column);
		}
		return neighbours;

	}

	private int neighboursInCell(Cell.CellState[][] state, int row, int column) {
		int neighbours = 0;
		if (column >= 0 && column < state[row].length) {
			if (state[row][column] == Cell.CellState.ALIVE) {
				neighbours++;
			}
		}
		return neighbours;
	}

	private int neighboursInRow(Cell.CellState[][] state, int row, int column) {
		int neighbours = 0;
		neighbours += neighboursInCell(state, row, column - 1);
		neighbours += neighboursInCell(state, row, column);
		neighbours += neighboursInCell(state, row, column + 1);
		return neighbours;
	}
}
