/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume that the top and the bottom sides of the square run parallel to thex-axis.
 */
public class P7_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square s1 = new Square(1, 1, 1);
		Square s2 = new Square(0, 0, 1);
		System.out.println(findLine(s1, s2));
		
		s1 = new Square(1, 1, 1);
		s2 = new Square(1, 0, 1);
		System.out.println(findLine(s1, s2));
	}
	
	public static double epsilon = 0.000001;
	
	public static Line findLine(Square square1, Square square2) {
		double slope, intercept;
		double x1 = square1.x + square1.length / 2;
		double x2 = square2.x + square2.length / 2;
		double y1 = square1.y - square1.length / 2;
		double y2 = square2.y - square2.length / 2;
		double dx = x1 - x2;
		double dy = y1 - y2;
		
		if(Math.abs(dx) < epsilon && Math.abs(dy) < epsilon) {
			throw new IllegalArgumentException("two squares are too close");
		} else if(dx < epsilon && dx >=0) {
			slope = Double.POSITIVE_INFINITY;
			intercept = x1;
		} else if (dx > -epsilon && dx < 0) {
			slope = Double.NEGATIVE_INFINITY;
			intercept = x1;
		} else {
			slope = dy / dx;
			intercept = (y2 * x1 - y1 * x2) / dx;
		}
		
		return new Line(new Point(x1, y1), new Point(x2, y2));
	}
	
	public static class Square {
		double x;//x and y are top left corner coordinates
		double y;
		double length;
		
		Square(double x, double y, double length) {
			if(length <= 0) {
				throw new IllegalArgumentException("Length must be positive");
			}
			
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
	
}
