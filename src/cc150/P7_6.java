/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P7_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[6];
		points[0] = new Point(1, 1);
		points[1] = new Point(0, 0);
		points[2] = new Point(1.0000000000001, 0.99999999999999);
		points[3] = new Point(0.000000001, -0.00000000001);
		points[4] = new Point(0, 1);
		points[5] = new Point(0, 2);
		System.out.println(findLine(points));
		
		Point[] points2 = new Point[6];
		points2[0] = new Point(1, 1);
		points2[1] = new Point(0, 0);
		points2[2] = new Point(1.0000000000001, 0.99999999999999);
		points2[3] = new Point(3, 0);
		points2[4] = new Point(1, 0);
		points2[5] = new Point(2, 0);
		System.out.println(findLine(points2));
	}
	
	//it's slow method. We will iterate throw every point, for each point, we
	//will iterate throw every existing line (there are O(N^2) of them) and every old point
	//so total time cost is O(N^3), total space cost is O(N^2) (saves all lines)
	//the advantage is it can handle lines whose slope is infinity
	
	//The method in the book is better, it doesn't handle infinity slope as well, but we can 
	//use Double.POSITIVE_INFINITY to handle it. Use interceptX to compare vertical lines
	//see the implementations in class Line
	public static LineByPoints findLine(Point[] points) {
		if(points.length <= 1) {
			throw new IllegalArgumentException("too few points");
		}
		
		ArrayList<LineByPoints> lines = new ArrayList<LineByPoints>();
		lines.add(new LineByPoints(points[0], points[1]));
		
		for(int i = 2; i < points.length; i++) {
			Point point = points[i];
			HashMap<Point, Boolean> connected = new HashMap<Point, Boolean>();
			for(int j = 0; j < i; j++) {
				connected.put(points[j], false);
			}
			
			for(LineByPoints line : lines) {
				if (line.onPoint(point)) {
					line.addPoint(point);
					for(Point p : line.points) {
						connected.put(p, true);
					}
				}
			}
			
			for(int j = 0; j < i; j++) {
				if(!connected.get(points[j])) {
					lines.add(new LineByPoints(points[i], points[j]));
				}
			}
		}
		
		int max = 0;
		LineByPoints maxLine = null;
		for(LineByPoints line : lines) {
			if(line.pointsSize() > max) {
				maxLine = line;
			}
		}
		
		return maxLine;
	}
	
}
