/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * You have a large text file containing words. Given any two words, 
 * find the shortest distance (in terms of number of words) between 
 * them in the file. If the operation will be repeated many times 
 * for the same file (but different pairs of words), can you optimize 
 * your solution?
 */
public class P18_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Hashtable<String, ArrayList<Integer>> wordPositions = null;
	
	public void parseWords(String[] words) {
		wordPositions = new Hashtable<String, ArrayList<Integer>>();
		for(int i = 0; i < words.length; i++) {
			if(! wordPositions.containsKey(words[i])) {
				wordPositions.put(words[i], new ArrayList<Integer>());
			}
			
			ArrayList<Integer> positions = wordPositions.get(words[i]);
			positions.add(i);
		}
	}
	
	public int smallestDistance(String word1, String word2) {
		if(!wordPositions.containsKey(word1) || !wordPositions.containsKey(word2)) {
			return Integer.MAX_VALUE;
		} else if (word1.equals(word2)) {
			return 0;
		}
		
		ArrayList<Integer> posList1 = wordPositions.get(word1);
		ArrayList<Integer> posList2 = wordPositions.get(word2);
		Iterator<Integer> iter1 = posList1.iterator();
		Iterator<Integer> iter2 = posList2.iterator();
		int pos1 = iter1.next(); //at least one position is guaranteed
		int pos2 = iter2.next();
		
		int min = Integer.MAX_VALUE;
		while(true) {
			int dif = Math.abs(pos1 - pos2);
			if(dif < min) {
				min = dif;
			}
			if(pos1 < pos2) {
				if(!iter1.hasNext()) {
					break;
				}
				pos1 = iter1.next();
			} else {
				if(!iter2.hasNext()) {
					break;
				}
				pos2 = iter2.next();
			}
		}
		
		return min;
	}
}
