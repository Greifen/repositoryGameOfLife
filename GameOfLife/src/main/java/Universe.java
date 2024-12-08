

public class Universe {

	
	private Cell.CellState[][] state;
	
	public Universe(Cell.CellState[][] cellStates) {
		state= new Cell.CellState[cellStates.length][];
		
		for (int i = 0; i < cellStates.length; i++) {  // Iterating through rows
			state[i] = new Cell.CellState[cellStates[i].length];
			
		    for (int j = 0; j < cellStates[i].length; j++) {  // Iterating through columns
		    	state[i][j]=cellStates[i][j];
		    }
		}
	
	}

	public Cell.CellState[][] getState() {
		return state;
	}





}
