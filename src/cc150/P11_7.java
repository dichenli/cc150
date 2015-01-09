/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * A circus is designing a tower routine consisting of people 
 * standing atop one anoth- er's shoulders. For practical and 
 * aesthetic reasons, each person must be both shorter and 
 * lighter than the person below him or her. Given the heights 
 * and weights of each person in the circus, write a method to 
 * compute the largest possible number of people in such a tower.
 */
public class P11_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] heights = {1, 2, 4, 3, 5, 7};
		double[] weights = {2, 1, 3, 5, 4, 0};
		Person[] circuit = new Person[heights.length];
		for(int i = 0; i < heights.length; i++) {
			circuit[i] = new Person(heights[i], weights[i]);
		}
		System.out.println(mostPeople(circuit));
	}

	static class Person implements Comparable<Person> {
		double height;
		double weight;
		
		Person(double height, double weight) {
			this.height = height;
			this.weight = weight;
		}
		
		public boolean canBeAbove(Person other) {
			return this.height < other.height && this.weight < other.weight;
		}
		
		@Override
		public int compareTo(Person other) {
			double dif = this.height - other.height;
			if(dif == 0) {
				return 0;
			}
			return dif > 0? 1 : -1;
		}
	}
	
	//time cost O(N^2)
	public static int mostPeople(Person[] circuit) {
		int len = circuit.length;
		for(int i = 0; i < len; i++) {
			if(circuit[i] == null) {
				throw new NullPointerException("Invalid input");
			}
		}
	
		Arrays.sort(circuit);
		int[] height = new int[len];
		Arrays.fill(height, 1);
		
		int maxHeight = 1;
		for(int i = 1; i < len; i++) {
			for(int j = i - 1; j >= 0; j--) {
				int thisHeight = height[j] + 1;
				if(thisHeight > height[i] && circuit[j].canBeAbove(circuit[i])) {
					height[i] = thisHeight;
					if(thisHeight > maxHeight) {
						maxHeight = thisHeight;
					}
				}
			}
		}
		return maxHeight;
	}
}
