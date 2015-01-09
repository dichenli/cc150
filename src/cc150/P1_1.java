package cc150;
import java.util.Random;
/*
1.1 Implement an algorithm to determine 
if a string has all unique characters. 
What if you cannot use additional data structures?
*/

public class P1_1 {

	public static void main(String[] args) {
		Method_1 a = new P1_1().new Method_1();
		Method_2 b = new P1_1().new Method_2();
		Method_3 c = new P1_1().new Method_3();
		System.out.println(a.unique("aa"));
		System.out.println(a.unique("abc"));
		System.out.println(b.unique("aa"));
		System.out.println(b.unique("abc"));
		System.out.println(c.unique("aaaaaaaaaaa"));
		System.out.println(c.unique("abc"));
		System.out.println(c.unique("bba"));
		System.out.println(c.unique("c"));
		System.out.println(c.unique("cb"));
		System.out.println(c.unique("bc"));
		System.out.println(c.unique("bcda"));
	}
	
	//method 1. use hash map. Space O(1) (256 bytes), time O(n)
	public class Method_1 {
		
		private final int R = 256;

		public boolean unique(String str) {
			boolean hash[] = new boolean[R]; //auto initialize as all false
			int size = str.length();
			
			if(size > R) return false; //size too big, impossible to have all non-repeated string
			
			for (int i = 0; i < size; i++) {
				if(hash[str.charAt(i)] == false) {
					hash[str.charAt(i)] = true;
				} else {
					return false;
				}
			}
			
			return true;
		}
	}
	
	//method 2. use bitmap, Improved from method 1. 
	//space O(1) (256 / 8 bytes), time O(n)
	public class Method_2 {
		private final int R = 256;
		
		public boolean unique (String str) {
			int size = str.length();
			if(size > R) return false;
			
			byte[] bitmap;
			if(R % 8 == 0) bitmap = new byte[R / 8];
			else bitmap = new byte[R / 8 + 1]; //auto initialized to all 0
			
			for(int i = 0; i < size; i++) {
				char c = str.charAt(i);
				int b = bitmap[c / 8];
				int n = c % 8;
				
				//for a bit, the n's bit value is (bit >> n) & 1
				if (((b >> n) & 1) == 1) return false;
				//set the n's bit to 1: bit = bit | (1 << n)
				else bitmap[c / 8] |= (1 << n);
			}
			
			return true;
		}
	}
	
	//method 3. use sort, space O(N), time O(logN)
	//In place sort is impossible since string is immutable. We need to convert string to char[]
	public class Method_3 {
		private final int R = 256;
		
		public boolean unique(String str){
			int size = str.length();
			if(size == 0) return true;
			if(size > R) return false;
			
			char[] str_a = new char[size];
			for(int i = 0; i < size; i++) {
				str_a[i] = str.charAt(i);
			}
			
			sort(str_a);
			
			for(int i = 0; i < size - 1; i++) {
				if(str_a[i] == str_a[i + 1]) return false;
			}
			return true;
		}
		
		//randomize the char[], this is required for quicksort
		private void randomize(char[] s) {
			Random ran = new Random();
			
			for(int i = 0; i < s.length - 1; i++) {
				int j = ran.nextInt(s.length - i - 1) + i;
				exch(s, i, j);
			}
		}
		
		private void exch(char[] s, int i, int j) {
			char t = s[i];
			s[i] = s[j];
			s[j] = t;
		}
		
		//sorting method is implemented here. But sorting can be done using java library method. See P1_3
		//use quick sort
		private int partition (char[] s, int lo, int hi) {
			int i = lo, j = hi;
			char pivot = s[(lo + hi) / 2];
//			char pivot  = s[hi];
			while( i <= j ) {
				while (s[i] < pivot) {
					i++;
				}
				while(s[j] > pivot) {
					j--;
				}
				
				if(i <= j) {
					if(s[i] > s[j]) exch(s, i, j);
					i++;
					j--;
				}
			}
			
			return i;
		}
		
		public void sort(char[] s) {
			randomize(s);
			sort(s, 0, s.length - 1);
			System.out.println(s);
		}
		
		private void sort(char[] s, int lo, int hi) {
			int i = partition(s, lo, hi);
			if(lo < i - 1) {
				sort(s, lo, i - 1);
			}
			if(hi > i) {
				sort(s, i, hi);
			}
		}
	}
}
