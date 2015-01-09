/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Imagine a robot sitting on the upper left comer of an X by Ygrid. Therobot can only move in two directions: right and down. How many possible paths are there for the robot togofrom (0,0) to (X, Y)?
 * FOLLOW UP 
 * Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class P9_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(paths(1, 1));
		P9_2 solution = new P9_2();
		
		Stack<Point> path = solution.findPath(3, 3);
		while(!path.isEmpty()) {
			System.out.println(path.pop());
		}
	}
	
	//the same problem was seen in CIS-160. The solution is to select
	//going down or right for each move, and the times for moving down and right should sum to X + Y
	//so the answer is C((x+y), x) (x+y choose x)
	//here it is DP solution
	public static long paths(int x, int y) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		
		long[][] paths = new long[y + 1][x + 1];
		for(int i = 0; i <= y; i++) {
			paths[i][0] = 1;
		}
		
		for(int j = 1; j <= x; j++) {
			paths[0][j] = 1;
		}
		
		for(int i = 1; i <= y; i++) {
			for(int j = 1; j <= x; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		
		return paths[y][x];
	}
	
	//follow-up
	Point[][] map;
	
	private class Point {
		int x;
		int y;
		boolean accessible;
		Point from;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.accessible = true;
			from = null;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	//return true if successful
	public boolean setAccessible(int x, int y, boolean accessible) {
		if(x < 0 || x >= map[0].length) {
			return false;
		} else if (y < 0 || y >= map.length) {
			return false;
		}
		map[y][x].accessible = accessible;
		return true;
	}
	
	public void initializeMap(int x, int y) {
		map = new Point[y + 1][x + 1];
		for(int i = 0; i <= y; i++) {
			for(int j = 0; j <= x; j++) {
				map[i][j] = new Point(j, i);
			}
		}
	}
	
	//dfs
	public Stack<Point> findPath(int x, int y) {
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		
		initializeMap(x, y);
		setAccessible(1, 0, false);
		setAccessible(0, 2, false); // define some inaccessible points here
		Stack<Point> stack = new Stack<Point>();
		
		Point p = map[0][0];
		stack.push(p);
		while(!stack.isEmpty()) {
			p = stack.pop();
			if(p.x == x && p.y == y) {
				break;
			}
			Point pNext;
			if(accessible(p.x + 1, p.y)) {
				pNext = map[p.y][p.x + 1];
				if(pNext.from == null) { //don't visit points already reached before
					pNext.from = p;
					stack.push(pNext);
				}
			}
			if(accessible(p.x, p.y + 1)) {
				pNext = map[p.y + 1][p.x];
				if(pNext.from == null) {
					pNext.from = p;
					stack.push(pNext);
				}
			}
		}
		
		if(p != map[y][x]) {
			return null;
		}
		
		stack = new Stack<Point>();
		while(p != null) {
			stack.push(p);
			p = p.from;
		}
		return stack;
	}
	
	private boolean accessible(int x, int y) {
		//TODO not implemented, needs a blacklist of inaccessible points
		if(x >= map[0].length) {
			return false;
		} else if (y >= map.length) {
			return false;
		}
		return map[y][x].accessible;
	}
}
