package examples.events.scribbledemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

//ScribblePanel for scribbling using the mouse
@SuppressWarnings("serial")
class ScribblePanel extends JPanel implements MouseListener, MouseMotionListener {
	final int CIRCLESIZE = 20; // Circle diameter used for erasing
	private final Point lineStart = new Point(0, 0); // Line start point

	public ScribblePanel() {
		// Register listener for the mouse event
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		lineStart.move(e.getX(), e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Create a Graphics object for drawing
		Graphics g = getGraphics();

		if (e.isMetaDown()) { // Detect right button pressed
			// Erase the drawing using an oval
			g.setColor(getBackground());
			g.fillOval(e.getX() - (CIRCLESIZE / 2), e.getY() - (CIRCLESIZE / 2), CIRCLESIZE, CIRCLESIZE);
		} else {
			g.setColor(Color.black);
			g.drawLine(lineStart.x, lineStart.y, e.getX(), e.getY());
		}

		lineStart.move(e.getX(), e.getY());

		// Dispose this graphics context
		g.dispose();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
