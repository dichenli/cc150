/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P17_11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rand5() {
		Random rand = new Random();
		return rand.nextInt(5);
	}
	
	public int rand2() {
		int i;
		do {
			i = rand5();
		} while(i == 4);
		return i % 2;
	}
	
	public int rand7() {
		int i;
		do {
			i = rand5();
			if(rand2() == 0) {
				i += 5;
			} 
		} while(i == 7 || i == 8 || i == 9);
		return i;
	}
}
