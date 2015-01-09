/**
 * 
 */
package cc150;
import java.util.LinkedList;
//import java.util.Hashtable;
//import java.util.NoSuchElementException;
//import java.util.Iterator;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P2_1 {

	/**
	 * Write code to remove duplicates from an unsorted linked list. 
	 * FOLLOW UP
	 * How would you solve this problem if a temporary buffer is not allowed?
	 * assumptions: the values in nodes are integers
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(4);
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(4);
		System.out.println(list.toString());
		deleteDup1(list);
		System.out.println(list.toString());
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		deleteDup1(list2);
		System.out.println(list2.toString());
		
		P2_1 a = new P2_1();
		a.solution2(); 
		a.solution3(); 
		a.solution4(); 
	}

	//method 1, use many java library classes, hashtable, linkedlist, iterator
	public static void deleteDup1(LinkedList<Integer> list) {
		//has to be Boolean, not boolean
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		
		//we need to use a iterator here, because iteration by 
		//	for(Integer i : list) 
		//does not support deletion during iteration
		for(Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
			Integer i = iter.next();
			if(table.containsKey(i)) {
				iter.remove();
			} else {
				table.put(i, true);
			}
		}
	}
	
	//solution 2, construct my own linkedlist and process deleteDup
	public void solution2() {
		MyLinkedList<Integer> list3 = new MyLinkedList<Integer>();
		list3.append(1);
		list3.append(2);
		list3.append(3);
		list3.append(4);
		list3.append(1);
		list3.append(2);
		list3.append(1);
		list3.append(1);
		list3.deleteDup();
		list3.printList();
	}
	
	//same as solution2, except using dummy node to simplify code, see MyLinkedList
	public void solution3() {
		MyLinkedList<Integer> list3 = new MyLinkedList<Integer>();
		list3.append(1);
		list3.append(2);
		list3.append(3);
		list3.append(4);
		list3.append(1);
		list3.append(2);
		list3.append(1);
		list3.append(1);
		list3.deleteDupDummyNode();
		list3.printList();
	}
	
	//solution 4, No Buffer Allowed
	public void solution4() {
		MyLinkedList<Integer> list3 = new MyLinkedList<Integer>();
		list3.append(1);
		list3.append(4);
		list3.append(2);
		list3.append(3);
		list3.append(4);
		list3.append(1);
		list3.append(2);
		list3.append(1);
		list3.append(1);
		list3.deleteDupNoBuffer();
		list3.printList();
	}
	
}
