import java.io.PrintStream;

import gameloop.Game;

public class GameOfLife implements Game<Void> {

	private Universe universe;
	private PrintStream output;

	public GameOfLife(Universe universe, PrintStream output) {
		this.universe = universe;
		this.output = output;

	}

	@Override
	public void update(Void input) {
		universe.nextState();
		
	}

	@Override
	public boolean isRunning() {
		return true;
	}

	@Override
	public void render() {
		output.println("+-+");
		if (universe.getState()[0][0] == Cell.CellState.ALIVE)
			output.println("|X|");
		else
			output.println("|O|");
		output.println("+-+");
	}

}
