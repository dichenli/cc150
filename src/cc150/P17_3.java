/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
public class P17_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(trailing0(5));
		System.out.println(trailing0(10));
		System.out.println(trailing0(11));
		System.out.println(trailing0(50));
	}

	public static int trailing0(int n) {
		if(n < 0) { //careful about exceptional input
			return -1;
		}
		
		int count5 = 0;
		for(int div = 5; n / div > 0; div *= 5) {
			count5 += n / div;
		}
		return count5;
	}
}
