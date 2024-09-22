import java.awt.Color;
import java.awt.Graphics;

public class DrawingVisitor implements EntityVisitor {
	private Graphics g;
	
	public DrawingVisitor(Graphics g) {
		this.g = g;
	}

	@Override
	public void visitPacman(Pacman p) {
		// TODO Draw Pac-Man
		MazePos pos = p.getPosition();
		
		g.setColor(Color.yellow);
		g.fillArc(pos.getX() * 10, pos.getY() * 10, 20, 20, 45, 270);

		g.setColor(Color.white);
		g.drawString("pacman", pos.getX() * 10, pos.getY() * 10);
	}

	@Override
	public void visitGhost(Ghost g) {
		// TODO Draw ghost
		
	}

	@Override
	public void visitMazeTile(MazeTile mt) {
		// TODO Draw maze tile
		MazePos pos = mt.getPosition();
		int x = pos.getX() * 40, y = pos.getY() * 40;
		System.out.println("POS: x="+pos.getX()+", y="+pos.getY());
		
		g.setColor(Color.blue);
		if (mt.hasWall(Direction.up)) g.drawLine(x, y, x + 40, y); 
		if (mt.hasWall(Direction.right)) g.drawLine(x + 40, y, x + 40, y + 40); 
		if (mt.hasWall(Direction.down)) g.drawLine(x, y + 40, x + 40, y + 40); 
		if (mt.hasWall(Direction.left)) g.drawLine(x, y, x, y + 40); 
	}

}
