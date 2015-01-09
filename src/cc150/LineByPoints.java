/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Define a line by two control points
 * for P7_6
 */
public class LineByPoints {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static final double epsilon = 0.000001;
	Point point1, point2;
	ArrayList<Point> points;
	double slope;
	double intercept;
	
	public LineByPoints(Point p1, Point p2) {
		this.point1 = p1;
		this.point2 = p2;
		points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		slope = slope(p1, p2);
		intercept = intercept(p1, p2);
	}
	
	public boolean onPoint(Point p) {
		double value1 = (point1.y - point2.y) * p.x + point2.y * point1.x;
		double value2 = (point1.x - point2.x) * p.y + point1.y * point2.x;
		return value1 - value2 < epsilon;
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}
	
	Iterable<Point> points() {
		return points;
	}
	
	int pointsSize() {
		return points.size();
	}
	
	public static double slope(Point p1, Point p2) {
		return (p1.y - p2.y) / (p1.x - p2.x);
	}
	
	public static double intercept(Point p1, Point p2) {
		return (p2.y * p1.x - p1.y * p2.x) / (p1.x - p2.x);
	}
	
	@Override
	public String toString() {
		return "y = " + slope + "x + (" + intercept + ")";
	}
}
