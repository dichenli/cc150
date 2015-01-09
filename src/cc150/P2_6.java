/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a circular linked list, implement an algorithm 
 * which returns the node at the beginning of the loop.
 */
public class P2_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testHasLoop();
		testLoopEntry();
	}
	
	public static void testHasLoop() {
		LinkedListNode<Integer> ptr1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> ptr2 = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> ptr3 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> ptr4 = new LinkedListNode<Integer>(4);
		ptr1.next = ptr2;
		ptr2.next = ptr3;
		ptr3.next = ptr4;
		ptr4.next = ptr2;
		System.out.println(hasLoop(ptr1));
		ptr4.next = null;
		System.out.println(hasLoop(ptr1));
	}
	
	public static void testLoopEntry() {
		LinkedListNode<Integer> ptr1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> ptr2 = new LinkedListNode<Integer>(2);
		LinkedListNode<Integer> ptr3 = new LinkedListNode<Integer>(3);
		LinkedListNode<Integer> ptr4 = new LinkedListNode<Integer>(4);
		ptr1.next = ptr2;
		ptr2.next = ptr3;
		ptr3.next = ptr4;
		ptr4.next = ptr2;
		LinkedListNode<Integer> ptr = loopEntry(ptr1);
		System.out.println(ptr.value);
	}
	
	public static boolean hasLoop(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> dummy = new LinkedListNode<Integer>();
		dummy.next = head;
		LinkedListNode<Integer> fast = dummy;
		LinkedListNode<Integer> slow = dummy;
		
		for(fast = fast.next; fast != slow; fast = fast.next) {
			if(fast == null) {
				return false;
			}
			fast = fast.next;
			if(fast == null) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}

	public static LinkedListNode<Integer> loopEntry(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> fast = head, slow = head;
		//dummy node is unnecessary here,with or without dummy, 
		//we still need to make judgement twice about whether fast.next.next exists
		do {
			if(fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		} while(slow != fast);
		
		while(slow != head) {
			slow = slow.next;
			head = head.next;
		}
		
		return slow;
	}
}
