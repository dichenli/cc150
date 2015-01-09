/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * An array A contains all the integers from 0 through n, 
 * except for one number which is missing. In this problem, 
 * we cannot access an entire integer in A with a single 
 * opera- tion. The elements of A are represented in binary, 
 * and the only operation we can use to access them is "fetch 
 * the jth bit of A[i]," which takes constant time. Write 
 * code to find the missing integer. Can you do it in 0(n) time?
 */
public class P5_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		for(int i = 0; i < n; i++) {
			ArrayList<BitInteger> list = new ArrayList<BitInteger>();
			for(int j = 0; j < n; j++) {
				if(j != i) {
					list.add(new BitInteger(j));
				}
			}
			System.out.println("Integer Removed: " + i);
			System.out.println("Integer Found: " + findMissing(list));
		}
	}

	public static int findMissing(ArrayList<BitInteger> input) {
		return findMissing(input, 0);
	}
	
	private static int findMissing(ArrayList<BitInteger> input, int column) {
		if(column >= BitInteger.INTEGER_SIZE) {
			return 0;
		}
		
		ArrayList<BitInteger> oneBit = new ArrayList<BitInteger>(input.size() / 2 + 1);
		ArrayList<BitInteger> zeroBit = new ArrayList<BitInteger>(input.size() / 2 + 1);
		
		for(BitInteger i : input) {
			int bit = i.fetch(BitInteger.INTEGER_SIZE - column - 1);
			if(bit == 1) {
				oneBit.add(i);
			} else {
				zeroBit.add(i);
			}
		}
		
		int bitSetter = 1 << column;
		if(oneBit.size() >= zeroBit.size()) {
			int v = findMissing(zeroBit, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBit, column + 1);
			return (v << 1) | 1;
		}
	}
}
