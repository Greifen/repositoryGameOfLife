import gameloop.Game;

public class GameOfLife implements Game<Void> {

	private Universe universe;

	public GameOfLife(Universe universe) {
		this.universe = universe;

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
		
	}

}
