import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

public class HandlerCluster implements Observer {

    @Override
    public void update (Observable o, Object arg1) {
        List<Point> points = BlackBoard.getInstance().getPoints();
        //{...}
// p.setColor (Color.BLUE);
    }
    private Point meanOfCluster (List<Point> cluster) {return null;}
    private double distance (Point a, Point b) {return 0;}
    private Point randomCenter (List<Point> points) {
        int randomNum = ThreadLocalRandom.current() .nextInt( 0, points.size());
        Point p = points.get (randomNum);
        return p;
    }
}