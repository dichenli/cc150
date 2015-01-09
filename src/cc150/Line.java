/**
 * 
 */
package cc150;

import cc150.P7_5.Square;

/**
 * @author dichenli
 * for P7_6 and P7_5
 * When implementing line, it's tricky about when slope is going close to infinity.
 * So in this class I also keeps a inverseSlope which is 1 / slope. So the equals method functions good
 * even when slope is infinity. It doesn't work as well when you try to implement hashCode though, 
 * because you still need to deal with infinite slope value when writing hash function 
 */
public class Line {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static final double epsilon = 0.000001;
	static final double threshold = 1 / epsilon;
	double slope;
	Double slopeFloor; //discrete slope values rounded by epsilon
	double intercept;
	double inverseSlope;
	Double inverseSlopeFloor;
	double interceptX;

	public Line(Point p1, Point p2) {
		this.slope = (p1.y - p2.y) / (p1.x - p2.x);
		this.slopeFloor = roundSlope(this.slope);
		this.intercept = (p2.y * p1.x - p1.y * p2.x) / (p1.x - p2.x);
		this.inverseSlope = (p1.x - p2.x) / (p1.y - p2.y);
		this.inverseSlopeFloor = roundSlope(this.inverseSlope);
		this.interceptX = (p2.x * p1.y - p1.x * p2.y) / (p1.y - p2.y);
		
	}

	public static Double roundSlope(double slope) {
		if(slope > threshold) {
			return Double.POSITIVE_INFINITY;
		}
		int n = (int) (slope / epsilon);
		return (Double) (n * epsilon);
	}
	
	@Override
	public String toString() {
		return "y = " + slope + "x + (" + intercept + ")";
	}
	
	@Override
	public boolean equals(Object line2) {
		if(!(line2 instanceof Line)) {
			return false;
		}
		
		if (Math.abs(((Line) line2).slopeFloor - this.slopeFloor) < epsilon
				&& Math.abs(((Line) line2).intercept - this.intercept) < epsilon) {
			return true;
		}
		if (Math.abs(((Line) line2).inverseSlopeFloor - this.inverseSlopeFloor) < epsilon
				&& Math.abs(((Line) line2).interceptX - this.interceptX) < epsilon) {
			return true;
		}
		
		return false;
	}

}
