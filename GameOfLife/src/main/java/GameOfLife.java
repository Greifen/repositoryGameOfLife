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
		output.print(
				"+-+-+-+\n"
				+"|0|0|0|\n"
				+"+-+-+-+\n"
				+"|0|0|0|\n"
				+"+-+-+-+\n"
				+"|0|0|0|\n"
				+"+-+-+-+\n");
	}

}
