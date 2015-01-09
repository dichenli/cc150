/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Implement a function to check if a linked list is a palindrome,
 */
public class P2_7 {

	public static void main(String[] args) {
		solution1();

	}
	
	public static void solution1() {
		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> list3 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> list4 = new MyLinkedList<Integer>(1);
		list1.append(9);
		list1.append(9); //list1 is 99
		list2.append(9);
		list2.append(0);
		list2.append(9); //list2 is 909
		list3.append(1);
		list3.append(1);
		list3.append(2);
		list3.append(2);
		System.out.println(isPalindrome(list1.getHead()));
		System.out.println(isPalindrome(list2.getHead()));
		System.out.println(isPalindrome(list3.getHead()));
		System.out.println(isPalindrome(list4.getHead()));
		System.out.println(isPalindrome2(list1.getHead()));
		System.out.println(isPalindrome2(list2.getHead()));
		System.out.println(isPalindrome2(list3.getHead()));
		System.out.println(isPalindrome2(list4.getHead()));
	}
	
	//first find middle point of linked list, then store the fast half values to an array, 
	//then iterate from the last to the first of the array, see if it matches each of the 
	//second half of the linked list
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		if(head == null) {
			return true;
		}
		
		//find middle point of list. if there are odd nodes, slow will stop in the middle,
		//if there are even number of nodes, slow will stop at next to the middle point
		LinkedListNode<Integer> fast = head, slow = head;
		int size = 0;
		do {
			size++;
			fast = fast.next;
			if(fast == null) {
				break;
			} 
			size++;
			slow = slow.next;
			fast = fast.next;
		} while (fast != null);
		
		Stack<Integer> stack = new Stack<Integer>();
		for(fast = head; fast != slow; fast = fast.next) {
			stack.push(fast.value);
		}
		
		//if it has odd nodes, the middle point doesn't matter
		if(size % 2 == 1) {
			slow = slow.next;
		}
		
		while(slow != null) {
			int num = stack.pop();
			if(slow.value != num) {
				return false;
			}
			slow = slow.next;
		}
		
		return true;
	}
	
	public static boolean isPalindrome2(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> list2 = reverseList(head);
		while(list2 != null) {
			if(list2.value != head.value) {
				return false;
			}
			list2 = list2.next;
			head = head.next;
		} //in fact, the second half of list don't need to be compared,
		//but we need to know the middle point to avoid that
		return true;
	}
	
	//create a new list that is the reverse of the original one.
	//The original one is intact
	public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> prev = null;
		LinkedListNode<Integer> newNode = null;
		while(head != null) {
			newNode = new LinkedListNode<Integer>(head.value);
			newNode.next = prev;
			prev = newNode;
			head = head.next;
		}
		
		return newNode;
	}
}
