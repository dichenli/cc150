/**
 * 
 */
package cc150;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
/**
 * @author dichenli
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated.
 */
public class P18_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {1, 4, 5, 3, 1, 2, 4, 5};
		P18_9 b = new P18_9(1);
		for(int i = 0; i < a.length; i++) {
			b.insert(a[i]);
			System.out.println(b.median());
		}
	}
	
	//keep two priority queues. The smaller pq prioritize the largest number to the pq top
	//Collections.reverseOrder(), return an Comparator<Object> instance that is the reverse of natural order
	//A better way to implement this method is not to keep int mid at all. Only a smaller and larger will be enough
	PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	PriorityQueue<Integer> larger = new PriorityQueue<Integer>();
	Integer mid = null;
	
	P18_9(int num) {
		this.mid = num;
	}
	
	public void insert(int num) {
		if(num < mid) {
			smaller.add(num);
		} else if(num > mid) {
			larger.add(num);
		} else if(difSize() > 0) {
			larger.add(num);
		} else {
			smaller.add(num);
		}
		balance();
	}
	
	private void balance() {
		while(difSize() > 1) {
			larger.add(mid);
			mid = smaller.poll();
		}
		while(difSize() < -1) {
			smaller.add(mid);
			mid = larger.poll();
		}
	}
	
	private int difSize() {
		return smaller.size() - larger.size();
	}
	
	public double median() {
		Integer mid = this.mid;
		
		if(smaller.size() > larger.size()) {
			return ((double) (mid + smaller.peek())) / 2;
		} else if (smaller.size() < larger.size()) {
			return ((double) (mid + larger.peek())) / 2;
		} else {
			return mid;
		}
	}

}
