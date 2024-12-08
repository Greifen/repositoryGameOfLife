
public class Universe {

	private Cell[][] cells;

	public Universe(Cell.CellState[][] cellStates) {
		cells = new Cell[cellStates.length][];

		for (int i = 0; i < cellStates.length; i++) { // Iterating through rows
			cells[i] = new Cell[cellStates[i].length];

			for (int j = 0; j < cellStates[i].length; j++) { // Iterating through columns
				cells[i][j] = new Cell(cellStates[i][j]);
			}
		}

	}

	public Cell.CellState[][] getState() {
		Cell.CellState[][] stateR = new Cell.CellState[cells.length][];

		for (int i = 0; i < cells.length; i++) { // Iterating through rows
			stateR[i] = new Cell.CellState[cells[i].length];

			for (int j = 0; j < cells[i].length; j++) { // Iterating through columns
				stateR[i][j] = cells[i][j].getCellState();
			}
		}
		return stateR;
	}

	public void nextState() {
		int[][] neighbour = new int[cells.length][];

		for (int i = 0; i < cells.length; i++) { // Iterating through rows
			neighbour[i] = new int[cells[i].length];
			
			for (int j = 0; j < cells[i].length; j++) { // Iterating through columns
				neighbour[i][j] = neighbours(i, j);
			}
		}

		for (int i = 0; i < cells.length; i++) { // Iterating through rows
			for (int j = 0; j < cells[i].length; j++) { // Iterating through columns
				cells[i][j].nextState(neighbour[i][j]);
			}
		}
	}

	private int neighbours(int row, int column) {
		int neighbours = 0;

		// obere Zeile
		neighbours += neighboursInRow(row - 1, column);

		// mittlere Zeile
		neighbours += neighbourInCell(row, column - 1);
		neighbours += neighbourInCell(row, column + 1);

		// untere Zeile
		neighbours += neighboursInRow(row + 1, column);

		return neighbours;

	}

	private int neighbourInCell(int row, int column) {

		if (column >= 0 && column < cells[row].length) {
			if (cells[row][column].getCellState() == Cell.CellState.ALIVE) {
				return 1;
			}
		}
		return 0;
	}

	private int neighboursInRow(int row, int column) {
		int neighbours = 0;
		if (row >= 0 && row < cells.length) {
			neighbours += neighbourInCell(row, column - 1);
			neighbours += neighbourInCell(row, column);
			neighbours += neighbourInCell(row, column + 1);
		}
		return neighbours;
	}
}
