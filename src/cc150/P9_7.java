/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Implement the "paint fill" function that one might see on 
 * many image editing programs. That is, given a screen 
 * (represented by a two-dimensional array of colors), a point, 
 * and a new color, fill in the surrounding area until the color 
 * changes from the original color.
 */
public class P9_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Color[][] pic = {{Color.RED,  Color.BLACK, Color.BLACK, Color.BLACK}, 
						{Color.WHITE, Color.RED,   Color.WHITE, Color.WHITE}, 
						{Color.GREEN, Color.BLACK, Color.RED,   Color.BLACK}};
		
		paint(pic, 2, 1, Color.RED);
		for(int i = 0; i < pic.length; i++) {
			for(int j = 0; j < pic[0].length; j++) {
				System.out.print(pic[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	enum Color{
		BLACK, WHITE, RED, BLUE, GREEN;
	}
	
	enum Direction {
		UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0);
		
		int dx, dy;
		Direction(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	}
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static Point moveByDirection(Point orig, Direction dir) {
		return new Point(orig.x + dir.dx, orig.y + dir.dy);
	}
	
	public static Color[][] paint(Color[][] picture, int x, int y, Color color) {
		if(x < 0 || y < 0 || picture.length <= 0 || picture[0].length <= 0
				 || y >= picture.length || x >= picture[0].length ) {
			return picture;
		}
		
		Color origCol = picture[y][x];
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			picture[p.y][p.x] = color;
			for(Direction dir : Direction.values()) {
				Point pNext = moveByDirection(p, dir);
				Color cNext = getColor(picture, pNext);
				if(cNext != null && origCol == cNext) {
					queue.add(pNext);
				}
			}
		}
		return picture;
	}
	
	private static Color getColor(Color[][] picture, Point p) {
		if(p.y < 0 || p.y >= picture.length || p.x < 0 || p.x >= picture[0].length) {
			return null;
		}
		return picture[p.y][p.x];
	}

}
