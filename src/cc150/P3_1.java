package cc150;
/**
 * @author dichenli
 * Describe how you could usea single array to implement three stacks.
 */
public class P3_1 {
	public static void main(String Args[]) {
		ThreeStacks stacks = new ThreeStacks();
		stacks.push(1, 1);
		stacks.push(1, 2);
		stacks.push(1, 3);
		stacks.push(1, 4);
		stacks.push(1, 10);
		while(!stacks.isEmpty(1)) {
			System.out.println(stacks.pop(1));
		}
		
	}
	
}
