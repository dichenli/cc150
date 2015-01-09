/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P17_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Hashtable<String, Integer> tagIntMap;
	
	public class Element {
		String tag;
		ArrayList<Attribute> attrs;
		ArrayList<Element> children;
		Element(String tag) {
			this.tag = tag;
			this.attrs = new ArrayList<Attribute>();
			this.children = new ArrayList<Element>();
		}
	}
	
	public class Value extends Element {
		String value;
		Value(String value) {
			super("");
			this.value = value;
			this.attrs = null;
			this.children = null;
		}
	}
	
	public class Attribute {
		String tag;
		String value;
	}
	
	public void mapTagToInt(String tag, Integer value) {
		tagIntMap.put(tag, value);
	}
	
	public int getTagInt(Element elem) {
		return tagIntMap.get(elem.tag);
	}
	
	public int getTagInt(Attribute attr) {
		return tagIntMap.get(attr.tag);
	}
	
	
	
	private void append(StringBuffer str, String value) {
		str.append(value);
		int len = str.length();
		if(len != 0 && str.charAt(len - 1) != ' ') {
			str.append(" ");
		}
	}
	
	private void append(StringBuffer str, Integer value) {
		append(str, value.toString());
	}
	
	private void append(StringBuffer str, Attribute attr) {
		append(str, getTagInt(attr));
		append(str, attr.value);
	}
	
	private void append(StringBuffer str, Element root) {
		if(root instanceof Value) {
			append(str, ((Value) root).value);
			return;
		}
		
		append(str, getTagInt(root));
		for(Attribute a : root.attrs) {
			append(str, a);
		}
		append(str, 0);
		for(Element e : root.children) {
			append(str, e);
		}
		append(str, 0);
	}
	
	public String compressXML(Element root) {
		StringBuffer str = new StringBuffer();
		append(str, root);
		return str.toString().trim();
	}
}
