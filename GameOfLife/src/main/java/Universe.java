

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
		
		Cell.CellState[][] stateR= new Cell.CellState[state.length][];
		
		for (int i = 0; i < state.length; i++) {  // Iterating through rows
			stateR[i] = new Cell.CellState[state[i].length];
			
		    for (int j = 0; j < state[i].length; j++) {  // Iterating through columns
		    	
		    	state[i][j].nextState(neighbours(i, j));
		    	stateR[i][j]=state[i][j].getCellState();
		    }
		}
		return new Universe(stateR);
	}

	private int neighbours(int i, int j) {
		int neighbours =0;
		if(i>0 && state[i-1][j].getCellState()==Cell.CellState.ALIVE) {
			neighbours++;
		}
		if(i<state.length-1 && state[i+1][j].getCellState()==Cell.CellState.ALIVE) {
			neighbours++;
		}
		if(j>0 && state[i][j-1].getCellState()==Cell.CellState.ALIVE) {
			neighbours++;
		}
		if(j<state[i].length-1 && state[i][j+1].getCellState()==Cell.CellState.ALIVE) {
			neighbours++;
		}
		return neighbours;
	}





}
