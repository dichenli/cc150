/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Self-defined linked list to facilitate linked-list related problems
 */
public class MyLinkedList<T extends Comparable<T>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private LinkedListNode head;
	private LinkedListNode tail;
	private int size; //size becomes useless after calling methods to answer questions

//	public class LinkedListNode<T extends Comparable<T>> {
//		T value;
//		LinkedListNode<T> next;
//
//		LinkedListNode(T value) {
//			this.next = null;
//			this.value = value;
//		}
//
//		LinkedListNode() {
//			this(null);
//		}
//		
//		//for testing purpose
//		public void printList() {
//			for(LinkedListNode<T> ptr = this; ptr != null; ptr = ptr.next) {
//				System.out.print(ptr.value + ", ");
//			}
//			System.out.println();
//		}
//	}

	public MyLinkedList () {
		head = null;
		tail = head;
		size = 0;
	}

	public MyLinkedList(T value) {
		head = new LinkedListNode<T>(value);
		tail = head;
		size = 1;
	}

	public void append(T value) {
		if(head == null) {
			head = new LinkedListNode<T>(value);
			tail = head;
		} else {
			tail.next = new LinkedListNode<T>(value);
			tail = tail.next;
		}
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public LinkedListNode<T> getHead() {
		return head;
	}

	public void delete(LinkedListNode<T> LinkedListNode) {
		LinkedListNode<T> ptr = head;
		while(ptr != null && ptr.next != LinkedListNode) {
			ptr = ptr.next;
		}

		if(ptr != null && ptr.next == LinkedListNode) {
			ptr.next = LinkedListNode.next;
			size--;
		}
	}

	//return the size of the list, as well as fix possible wrong values of this.size
	public int getCorrectSize() {
		int size = 0;
		for(LinkedListNode<T> ptr = head; ptr != null; ptr = ptr.next) {
			size++;
		}
		this.size = size;
		return size;
	}
	
	//for testing purpose
	public void printList() {
		for(LinkedListNode<T> ptr = head; ptr != null; ptr = ptr.next) {
			System.out.print(ptr.value + ", ");
		}
		System.out.println();
	}

	//method as required from P2_1
	public void deleteDup() {
		Hashtable<T, Boolean> table = new Hashtable<T, Boolean>();
		if(head == null) {
			return;
		} else {
			try {
				table.put((T) head.value, true);
			} catch (NullPointerException e) {
				//if value is null, just don't insert it
			}
		}

		for(LinkedListNode<T> ptr = head; ptr.next != null; ) {
			if(table.containsKey((T) ptr.next.value)) {
				ptr.next = ptr.next.next;
			} else {
				table.put((T) ptr.next.value, true);
				ptr = ptr.next;
			}
		}
	}

	//use dummy LinkedListNode, method is shortened a lot
	public void deleteDupDummyNode() {
		Hashtable<T, Boolean> table = new Hashtable<T, Boolean>();
		LinkedListNode<T> dummy = new LinkedListNode<T>();
		dummy.next = head;
		
		while(dummy.next != null) {
			if(table.containsKey(dummy.next.value)) {
				dummy.next = dummy.next.next;
			} else {
				table.put(dummy.next.value, true);
				dummy = dummy.next;
			}
		}
	}
	
	//method as required from P2_1
	public void deleteDupNoBuffer() {
		for(LinkedListNode<T> ptr = head; ptr != null; ) {
			for(LinkedListNode<T> ptr2 = head; true; ptr2 = ptr2.next) {
				if(ptr2 != ptr && ptr2.value == ptr.value) {
					ptr2 = ptr;
					ptr = ptr.next;
					delete(ptr2);
					break;
				} else if(ptr2 == ptr) {
					ptr = ptr.next;
					break;
				} else {
					continue;
				}
			}
			
		}
	}
	
	//solution to P2_2
	//here k >= 1, k == 1 means to return the last element
	//when doing fast slow pointer, it's better not to have dummy LinkedListNode, 
	//otherwise it's easy to return the dummy LinkedListNode itself by mistake.
	public T kthToLast(int k) {
		if(k <= 0 || head == null) {
			return null;
		}
		
		LinkedListNode<T> fast = head;
		LinkedListNode<T> slow = head; //now slow is on a dummy LinkedListNode, and it is slower than fast by 1 LinkedListNode
		
		for(int i = 1; i < k; i++) {
			if(fast.next == null) {
				return null;
			} else {
				fast = fast.next;
			}
		}
		
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow.value;
	}

	//P2_3, the restriction is that you have no access to head LinkedListNode. 
	//The assumption is that the LinkedListNode is in the middle of list, not the beginning or last
	public void deleteThisNode(LinkedListNode<T> LinkedListNode) throws IllegalArgumentException {
		if(LinkedListNode == null || LinkedListNode.next == null) {
			throw new IllegalArgumentException();
		}
		
		LinkedListNode.value = LinkedListNode.next.value;
		LinkedListNode.next = LinkedListNode.next.next;
	}
	
	//P2_4
	//use dummy LinkedListNodes to avoid if statements
	//compareTo method is readily available for classes implementing comparable
	public void partitionLinkedList(T value) {
		LinkedListNode<T> low = new LinkedListNode<T>();
		LinkedListNode<T> high = new LinkedListNode<T>();
		LinkedListNode<T> lowTail = low;
		LinkedListNode<T> highTail = high;
		
		for(LinkedListNode<T> ptr = head; ptr != null; ptr = ptr.next) {
			if(ptr.value.compareTo(value) < 0) {
				lowTail.next =ptr;
				lowTail = lowTail.next;
			} else {
				highTail.next =ptr;
				highTail = highTail.next;
			}
		}
		
		highTail.next = null;
		lowTail.next = high.next;
		head = low.next;
	}
	
	//P2_5, the numbers are in reverse order
	//I assume inputs are valid, otherwise many if statements are needed to check that
	//such as if every LinkedListNode is non null and integer between 0 to 9
	//in this method, new memory is allocated, the advantage is this method is non-destructive
	//if we need to save space, we can use space of num1 and num2.
	public LinkedListNode<Integer> addNumberReverse(LinkedListNode<Integer> num1, LinkedListNode<Integer> num2) {
		Integer carry = 0;
		LinkedListNode<Integer> sum = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer> tail = sum;
		
		while(num1 != null || num2 != null) {
			tail.next = new LinkedListNode<Integer>(carry);
			tail = tail.next;
			
			if(num1 != null) {
				tail.value += num1.value;
				num1 = num1.next;
			}
			if(num2 != null) {
				tail.value += num2.value;
				num2 = num2.next;
			}
			
			carry = tail.value / 10;
			tail.value = tail.value % 10;
		}
		
		//last check
		if(carry != 0) {
			tail.next = new LinkedListNode<Integer>(carry);
		}
		return sum.next;
	}
	
	//P2_5, follow up, what if it is reversed?
	//we just reverse the lists then it becomes the same problem
	//the cost is large though, for three reverses, the total time is O(2(n1 + n2))
	public LinkedListNode<Integer> addNumber(LinkedListNode<Integer> num1, LinkedListNode<Integer> num2) {
		num1 = reverseList(num1);
		num2 = reverseList(num2);
		LinkedListNode<Integer> sum = addNumberReverse(num1, num2);
		return reverseList(sum);
	}
	
	public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> ptr1 = null;
		LinkedListNode<Integer> ptr2 = head;
		LinkedListNode<Integer> ptr3;
		while(ptr2 != null) {
			ptr3 = ptr2.next;
			ptr2.next = ptr1;
			ptr1 = ptr2;
			ptr2 = ptr3;
		}
		return ptr1;
	}
}
