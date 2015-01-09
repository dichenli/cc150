/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a method to return all subsets of a set.
 */
public class P9_4<E> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(3);
		Set<Integer>[] subsets = (new P9_4<Integer>()).allSubsets(set);
		for(int i = 0; i < subsets.length; i++) {
			for(Integer integer : subsets[i]) {
				System.out.print(integer + ", ");
			}
			System.out.println();
		}
	}
	
	//the method can't static because E is not a well-defined class type, it is related
	//to the definition of an instance.
	public Set<E>[] allSubsets(Set<E> set) {
		//I can't choose to use iterable classes such as ArrayList here. Because I need
		//to do iteration and do array mutation (i.e. modification) at the same time. 
		//a way to avoid that is to use ArrayList.addAll() method to copy from list to list
		//It will cause concurrentModificationException
		//The only choice is simple array. But luckily I can predict the size needed (2^n) 
		//of an array, so it's not too bad.
		HashSet<E>[] subsets = (HashSet<E>[]) new HashSet[1 << set.size()]; //1 << n to compute 2^n
		subsets[0] = new HashSet<E>(); //add in empty set
		
		E[] elems = (E[]) set.toArray();
		for(int i = 0; i < elems.length; i++) {
			int size = 1 << i;
			for(int j = 0; j < size; j++) {
				Set<E> s = subsets[j];
				//cast here is painful, but clone() is a method of HashSet, But I used set class. So...
				HashSet<E> newSet = (HashSet<E>) ((HashSet<E>) s).clone(); //clone returns an Object type, so cast needed
				newSet.add(elems[i]);
				subsets[j + size] = newSet;
			}
		}
		return subsets;
	}
}
