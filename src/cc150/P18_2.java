/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other words, each of the 52! permutations of the deck has to be equally likely. Assume that you are given a random number generator which is perfect.
 */
public class P18_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//similar to Princeton algorithm course method
	public static int[] shuffleCard(int[] deck) {
		Random rand = new Random();
		int len = deck.length;
		for(int i = 0; i < len; i++) {
			int j = rand.nextInt(len - i) + i; //random number from i to len - 1
			exch(deck, i, j);
		}
		return deck;
	}
	
	private static int[] exch(int[] deck, int i, int j) {
		int temp = deck[i];
		deck[i] = deck[j];
		deck[j] = temp;
		return deck;
	}
	
}
