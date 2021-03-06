/**

 * 
 * Author: Jai Surya Palle
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class WorkAreaPanel extends JPanel implements MouseListener {
    public WorkAreaPanel() {
        setBackground(Color.GRAY);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    // When mouse click is released on the Work Area a new point is created.

    @Override
    public void mouseReleased(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY(), Color.BLACK);
        BlackBoard.getInstance().addPoint(p);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        // points

        List<Point> points = BlackBoard.getInstance().getPoints();
        if (points == null) return;
        g.setColor(Color.BLACK);
        for (Point p : points) {
            if (Color.BLUE.equals(p.getColor())) {
                g.setColor(Color.BLUE);
            } else if (Color.RED.equals(p.getColor())) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillOval(p.getX() - 5, p.getY() - 5, 10, 10);
        }

        // lines
        
        List<Line> lines = BlackBoard.getInstance().getLines();
        if (lines == null) return;
        for (Line l : lines) {
            Point x1 = l.getEndPoint1();
            Point x2 = l.getEndPoint2();
            g.setColor(Color.ORANGE);
            g.drawLine(x1.getX(), x1.getY(), x2.getX(), x2.getY());
        }
    }

    public void clearAll() {
        BlackBoard.getInstance().clearAll();
        repaint();
    }
}
