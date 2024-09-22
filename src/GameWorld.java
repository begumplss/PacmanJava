import java.util.ArrayList;

public class GameWorld {
	
	private int score;
	private MazeTile[][] maze = {
			{ new MazeTile(this, true, false, false, true, null), new MazeTile(this, true, true, false, false, null) },
			{ new MazeTile(this, false, false, false, true, null), new MazeTile(this, false, true, false, false, null) },
			{ new MazeTile(this, false, false, false, true, null), new MazeTile(this, false, true, false, false, null) },
			{ new MazeTile(this, false, false, false, true, null), new MazeTile(this, false, true, false, false, null) },
			{ new MazeTile(this, false, false, false, true, null), new MazeTile(this, false, true, false, false, null) },
			{ new MazeTile(this, false, true, true, true, null), new MazeTile(this, false, true, true, false, null) }
	};
	private Pacman pacman = new Pacman(this);
	
	private ArrayList<Entity> entities = new ArrayList<>();

	public GameWorld() {
		entities.add(pacman);
		entities.add(new Blinky(this));
		entities.add(new Pinky(this));
		entities.add(new Inky(this));
		entities.add(new Clyde(this));
		
		for (int y = 0; y < maze.length; y++) for (int x = 0; x < maze[0].length; x++) {
			maze[y][x].setPosition(new MazePos(x + 1, y + 1));
		}
	}
	
	public void tick() {
		for (Entity e : entities) e.tick();
	}
	
	public void didEatItem(Item item) {
		score += item.pointValue();
	}

	public MazeTile mazeTileAt(MazePos pos) {
		return maze[pos.getY() - 1][pos.getX() - 1];
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
