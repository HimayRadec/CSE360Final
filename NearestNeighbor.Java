java.lang.Math.*;

public class NearestNeighbor {

    ArrayList<Point> nearestNeighbor;

    NearestNeighbor(){

    }

    public void findNearestNeighbor(ArrayList<Point> unsortedPoints){
        int size = unsortedPoints.size();

        for (int i = 1; i < n; ++i ){
            int key = calculateDistance(unsortedPoints.get(i));
            int j = i - 1;

            while (j >= 0 && calculateDistance(unsortedPoints.get(j) > key) {
                
            }
        }

    }

    public int calculateDistance(Point p){
        int distance = abs(p.getX()) + abs(p.getY()) / 2 ;
        return distance;
    }

    public int[] InsertionSort(ArrayList<Point> unsortedPoints) {
        
		for (int i = 1; i < unsortedPoints.size(); i++ ) {
			int j = i;
			while ((j > 0) && (calculateDistance(unsortedPoints.get(j-1)) > calculateDistance(unsortedPoints.get(j))) {

                Connections.swap(unsortedPoints, j, j -1);
				j--;
						
			}
		}
}