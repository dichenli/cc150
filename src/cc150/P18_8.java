/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a string s and an array of smaller strings T, design a method to search s for each small string in T.
 * Answer see SuffixTree class
 */
public class P18_8 {

	public static void main(String[] args) {
		SuffixTree tree = new SuffixTree("awesomesome");
		System.out.println(tree.search("we"));
		System.out.println(tree.search(""));
		System.out.println(tree.search("awesome"));
		System.out.println(tree.search("so"));
		System.out.println(tree.search("awb"));
		System.out.println(tree.search("awesomeaa"));
		System.out.println(tree.search(null));
		String s = "1";
		System.out.println(s.substring(1));
	}

}
