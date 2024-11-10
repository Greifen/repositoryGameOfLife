
public class Cell {
	

	
	private Cell.CellState cellState;

	public Cell(Cell.CellState cellstate) {
		this.cellState = cellstate;
		// TODO Auto-generated constructor stub
	}


	public Cell.CellState getCellState() {
		return cellState;
	}

	public enum CellState{
			ALIVE, DEAD
	}

	public void nextState(int i) {
		cellState=Cell.CellState.DEAD;	
	}




	
}
