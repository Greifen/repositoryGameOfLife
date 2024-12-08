

public class Universe {

	
	private Cell [][] state;
	
	public Universe(Cell.CellState[][] cellStates) {
		state= new Cell[cellStates.length][];
		
		for (int i = 0; i < cellStates.length; i++) {  // Iterating through rows
			state[i] = new Cell[cellStates[i].length];
			
		    for (int j = 0; j < cellStates[i].length; j++) {  // Iterating through columns
		    	state[i][j]=new Cell(cellStates[i][j]);
		    }
		}
	
	}

	public Cell.CellState[][] getState() {
		Cell.CellState[][] stateR= new Cell.CellState[state.length][];
		
		for (int i = 0; i < state.length; i++) {  // Iterating through rows
			stateR[i] = new Cell.CellState[state[i].length];
			
		    for (int j = 0; j < state[i].length; j++) {  // Iterating through columns
		    	stateR[i][j]=state[i][j].getCellState();
		    }
		}
		return stateR;
	}

	public Universe nextState() {
		Cell.CellState[][] copyCellStates = getState();
		
		Cell.CellState[][] stateR= new Cell.CellState[state.length][];
		
		for (int i = 0; i < state.length; i++) {  // Iterating through rows
			stateR[i] = new Cell.CellState[state[i].length];
			
		    for (int j = 0; j < state[i].length; j++) {  // Iterating through columns
		    	
		    	state[i][j].nextState(neighbours(copyCellStates,i, j));
		    	stateR[i][j]=state[i][j].getCellState();
		    }
		}
		return new Universe(stateR);
	}

	private int neighbours(Cell.CellState[][] state, int row, int column) {
		int neighbours =0;
		
		//obere Zeile
		if(row>0) {
			int rowAbove = row-1;
			if(column>0) {
				if(state[rowAbove][column-1]==Cell.CellState.ALIVE) {
					neighbours++;
				}
			}
			if(state[rowAbove][column]==Cell.CellState.ALIVE) {
				neighbours++;
			}
			if(column<state[rowAbove].length-1) {
				if(state[rowAbove][column+1]==Cell.CellState.ALIVE) {
					neighbours++;
				}
			}	
		}
		
		//mittlere Zeile
		if(column>0) {
			if(state[row][column-1]==Cell.CellState.ALIVE) {
				neighbours++;
			}
		}
		if(column<state[row].length-1) {
			if(state[row][column+1]==Cell.CellState.ALIVE) {
				neighbours++;
			}
		}
		
		//untere Zeile
		if(row<state.length-1)
		{
			int rowUnder = row+1;
			if(column>0) {
				if(state[rowUnder][column-1]==Cell.CellState.ALIVE) {
					neighbours++;
				}
			}
			if(state[rowUnder][column]==Cell.CellState.ALIVE) {
				neighbours++;
			}
			if(column<state[rowUnder].length-1) {
				if(state[rowUnder][column+1]==Cell.CellState.ALIVE) {
					neighbours++;
				}
			}
		}
		return neighbours;
			
	}
}
