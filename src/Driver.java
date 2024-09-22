import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver {
	private static final long NANOSECONDS_PER_TICK = 1000000000 / 20;
	
	private static final GameWorld world = new GameWorld();
	private static long time = System.nanoTime();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacmanWindow win = new PacmanWindow();
		
		while (true) {
			long dt = System.nanoTime() - time;
			if (dt >= NANOSECONDS_PER_TICK) {
				time += dt;
				world.tick();
				win.repaint();
				System.out.println("tick");
			}
		}
		
	}
	
	private static class PacmanWindow extends JPanel {
		private static final long serialVersionUID = 1L;
		private static final int w = 400, h = 400;
		
		public PacmanWindow() {
			super();
			
			JFrame jf = new JFrame("Pac-Man");
		    jf.setSize(w, h);
		    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close button to exit
		    
		    jf.add(this);
		    
		    jf.setVisible(true);
		    this.setVisible(true);
		}
		
		@Override
		public void paint(Graphics g) {
			
			DrawingVisitor drawing = new DrawingVisitor(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, w, h);
			
			for (Entity e : world.getEntities()) {
				e.accept(drawing);
			}
			
			for (int y = 1; y <= 6; y++) for (int x = 1; x <= 2; x++) {
				world.mazeTileAt(new MazePos(x, y)).accept(drawing);
			}
			world.toString();
		}
	}

	
}
