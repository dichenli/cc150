/**
 * 
 */
package cc150;

/**
 * @author dichenli
 *  Write a method to count the number of 2s between0 and n.
 */
public class P18_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		print(2);
		print(11);
		print(99);
		print(251);
		print(62519);
		print(200);
	}
	
	public static void print(int n) {
		System.out.println(count2(n));
		System.out.println(countBrute(n));
	}

	public static int count2(int n) {
		int sum = 0;
		int digit = 1; //digittude
		while(n / digit > 0) { //loop through each digit
			//the bulk part number that is smaller than n while divisible by digit * 10
			sum += (n / (10 * digit)) * digit;
			//the remnant. For example, for 1252, 1000 to 1252 are remnants, there are 253 remnants
			//(0 to 999 are bulk, which guarantee 100 2's at the 3rd digit (when digit == 100))
			int remnant = n % (digit * 10) + 1;  
			sum += remnant2(remnant, digit);
			digit *= 10;
		}
		return sum;
	}
	
	private static int remnant2(int remnant, int digit) {
		//for example, 253 - 2 * 100 == 53, which means there are 53 numbers that >= 200 but <= 999
		int count = remnant - 2 * digit;
		if(count > digit) {
			return digit;
		} else if (count < 0) {//if remnant == 111, 111 - 2 * 100 < 0, so return 0 (there are no 2's at the 3rd digit for these remnant numbers)
			return 0;
		} else {
			return count;
		}
	}
	
	//brute force method
	public static int countBrute(int n) {
		int count = 0;
		for(int i = 0; i <= n; i++) {
			for(int j = i; j >= 1; j /= 10) {
				if(j % 10 == 2) {
					count++;
				}
			}
		}
		return count;
	}
}
