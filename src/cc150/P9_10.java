/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * You have a stack of n boxes, with widths wi, heights hi and depths di.
 * The boxes cannot be rotated and can only be stacked on top of one 
 * another if each box in the stack is strictly larger than the box 
 * above it in width, height, and depth. Implement a method to build 
 * the tallest stack possible, where the height of a stack is the sum 
 * of the heights of each box.
 */
public class P9_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Box[] boxes = new Box[4];
		boxes[0] = new Box(1, 2, 1);
		boxes[1] = new Box(2, 3, 2);
		boxes[2] = new Box(3, 1, 3);
		boxes[3] = new Box(4, 4, 4);
		ArrayList<Box> stack = findHighStack(boxes);
		for(Box b : stack) {
			System.out.println(b);
		}
	}

	private static class Box {
		int w;
		int h;
		int d;

		Box(int w, int h, int d) {
			this.w = w;
			this.h = h;
			this.d = d;
		}

		boolean canBeBelow(Box other) {
			return this.w > other.w && this.h > other.h && this.d > other.d;
		}

		boolean canBeAbove(Box other) {
			return other.canBeBelow(this);
		}
		
		@Override
		public String toString() {
			return "w: " + w + ", h: " + h + ", d: " + d;
		}
	}

	public static ArrayList<Box> findHighStack(Box[] boxes) {
		if(boxes.length <= 0) {
			return null;
		}

		ArrayList<Box>[] maxStacks = (ArrayList<Box>[]) new ArrayList[boxes.length];
		Arrays.fill(maxStacks, null); //initialize to all null
		int[] maxHeights = new int[boxes.length];
		Arrays.fill(maxHeights, 0); //initialize to all 0

		for(int i = 0; i < boxes.length; i++) {
			maxStacks[i] = findHighStack(boxes, i, maxStacks, maxHeights);
		}

		int maxIndex = 0;
		for(int i = 1; i < boxes.length; i++) {
			if(maxHeights[i] > maxHeights[maxIndex]) {
				maxIndex = i;
			}
		}

		return maxStacks[maxIndex];
	}

	private static ArrayList<Box> findHighStack(Box[] boxes, int i, ArrayList<Box>[] maxStacks, int[] maxHeights) {
		if(maxStacks[i] != null) {
			return maxStacks[i];
		}

		ArrayList<Box> stack = new ArrayList<Box>();
		ArrayList<Box> stackAbove = null;
		int max = boxes[i].h;
		for(int j = 0; j < boxes.length; j++) {
			if(boxes[j].canBeAbove(boxes[i])) {
				ArrayList<Box> stackJ = findHighStack(boxes, j, maxStacks, maxHeights);
				int height = maxHeights[j] + boxes[i].h;
				if(height > max) {
					max = height;
					stackAbove = stackJ;
				}
			}
		}

		if(stackAbove != null) {
			stack.addAll(stackAbove); //copy list
		}
		stack.add(boxes[i]);
		maxHeights[i] = max;
		return stack;
	}
}
