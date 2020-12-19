package biblio_univ;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class MotionPanel extends JPanel {
    private Point initialClick;
    private JFrame parent;

    public MotionPanel(final JFrame parent) {
    	setSize(new Dimension(600, 25));
    	setBackground(new Color(240, 240, 240, 0));
	    this.parent = parent;
	    setSize(600, 30);
	    setLayout(null);
	
	    addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
	        }
	    }
	);

    addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {

            // get location of Window
            int thisX = parent.getLocation().x;
            int thisY = parent.getLocation().y;

            // Determine how much the mouse moved since the initial click
            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            // Move window to this position
            int X = thisX + xMoved;
            int Y = thisY + yMoved;
            parent.setLocation(X, Y);
        }
    });
    }
}