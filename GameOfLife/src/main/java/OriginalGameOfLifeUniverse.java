

public class OriginalGameOfLifeUniverse implements Universe {

	private Cell[][] cells;

	public OriginalGameOfLifeUniverse(Cell.CellState[][] cellStates) {
		cells = new Cell[cellStates.length][];

		for (int i = 0; i < cellStates.length; i++) { // Iterating through rows
			cells[i] = new Cell[cellStates[i].length];

			for (int j = 0; j < cellStates[i].length; j++) { // Iterating through columns
				cells[i][j] = new Cell(cellStates[i][j]);
			}
		}

	}

	@Override
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

	@Override
	public void nextState() {
		int[][] neighbour = new int[cells.length][];

		for (int row = 0; row < cells.length; row++) { // Iterating through rows
			neighbour[row] = new int[cells[row].length];

			for (int column = 0; column < cells[row].length; column++) { // Iterating through columns
				neighbour[row][column] = neighbours(row, column);
			}
		}

		for (int row = 0; row < cells.length; row++) { // Iterating through rows
			for (int column = 0; column < cells[row].length; column++) { // Iterating through columns
				cells[row][column].nextState(neighbour[row][column]);
			}
		}
	}

	private int neighbours(int row, int column) {
		int neighbours = 0;

		// obere Zeile
		neighbours += neighboursInRow(row - 1, column);

		// mittlere Zeile
		if (getCell(row, column-1).isAlive()) neighbours++;
		if (getCell(row, column+1).isAlive()) neighbours++;

		// untere Zeile
		neighbours += neighboursInRow(row + 1, column);

		return neighbours;
	}

	private Cell getCell(int row, int column) {
		if (column >= 0 && column < cells[row].length) {
			return cells[row][column];
		}
		return new Cell(Cell.CellState.DEAD);
	}

	private int neighboursInRow(int row, int column) {
		int neighbours = 0;
		if (row >= 0 && row < cells.length) {
			if (getCell(row, column-1).isAlive()) neighbours++;
			if (getCell(row, column).isAlive()) neighbours++;
			if (getCell(row, column+1).isAlive()) neighbours++;
		}
		return neighbours;
	}
}
