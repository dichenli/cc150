/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * TheCameof Master Mind isplayed asfollows:
The computer has four slots, and each slot will contain a ball that is red (R), yellow (Y), green (C) or blue (B). For example, the computer might have RGGB (Slot # 1isred, Slots #2 and #3 are green, Slot #4 is blue).
You, the user, are trying to guess the solution. Youmight, for example, guess YRGB.
When you guess the correct color for the correct slot, you get a "hit." If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit." Note that a slot that is a hit can never count as a pseudo-hit.
For example,if the actual solution is RGBYandyou guess GGRR, you have one hit and onepseudo-hit.
Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
 */
public class P17_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Result {
		int hit;
		int pseudo;
		Result(int hit, int pseudo) {
			this.hit = hit;
			this.pseudo = pseudo;
		}
	}
	
	public static Result masterMind(String guess, String solution) {
		if(guess == null || solution == null || guess.length() != 4 || solution.length() != 4) {
			return null;
		}
		
		Hashtable<Character, Integer> set = new Hashtable<Character, Integer>();
		set.put('R', 0); //hash from char to index in count[] array
		set.put('Y', 1);
		set.put('C', 2);
		set.put('B', 3);
		
		char[] gue = guess.toCharArray();
		char[] sol = solution.toCharArray();
		int[] count = new int[4];
		Arrays.fill(count, 0);
		int hit = 0;
		int pseudo = 0;
		
		for(int i = 0; i < 4; i++) {
			if(!set.containsKey(gue[i]) || !set.containsKey(sol[i])) {
				return null;
			}
			if(gue[i] == sol[i]) {
				hit++;
				gue[i] = ','; //meaningless chars
				sol[i] = '.';
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(set.containsKey(sol[i])) {
				int j = set.get(sol[i]);
				count[j]++;
			}
		}
		for(int i = 0; i < 4; i++) {
			if(set.containsKey(gue[i])) {
				int j = set.get(gue[i]);
				if(count[j] > 0) {
					pseudo++;
					count[j]--;
				}
			}
		}
		
		return new Result(hit, pseudo);
	}
}
