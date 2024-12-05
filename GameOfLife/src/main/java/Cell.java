
public class Cell {
	
	private CellState cellState;

	public Cell(CellState cellstate) {
		this.cellState = cellstate;
		// TODO Auto-generated constructor stub
	}


	public CellState getCellState() {
		return cellState;
	}

	public enum CellState{
			ALIVE, DEAD
	}

	public void nextState(int anzahlNachbarn) {
		if(cellState==CellState.ALIVE) {
			//underpopulation, overcrowding
			if(anzahlNachbarn<2||anzahlNachbarn>3) {
				cellState=CellState.DEAD;	
			}
			//survival
		}
		else
		{
			//reproduction
			if(anzahlNachbarn==3)
			{
				cellState=CellState.ALIVE;
			}
		}
	}




	
}
