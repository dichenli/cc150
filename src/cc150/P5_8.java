/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * A monochrome screen is stored as a single array of bytes, 
 * allowing eight consecutive pixels to be stored in one byte. 
 * The screen has width w, where w is divisible by 8 (that is, 
 * no byte will be split across rows). The height of the screen, 
 * of course, can be derived from the length of the array and 
 * the width. Implement a function 
 * drawHorizontalLine(byte[] screen,int width, intxl, intx2, inty) 
 * which draws a horizontal line from (x1,y) to (x2, y).
 */
public class P5_8 {

	static byte[] screen;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		drawHorizontalLine(64, 3, 28, 1);
		drawHorizontalLine(64, 3, 3, 1);
	}
	public static void drawHorizontalLine(int width, int x1, int x2, int y) {
		screen = new byte[64];
		screen = makeHorizontalLine(screen, width, x1, x2, y);
		for(int i = 0; i < 64; i++) {
			String s1 = String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0');
			System.out.print(s1 + ",");
			if((i + 1) % 8 == 0) {
				System.out.println();
			}
		}
	}
	
	private static byte[] makeHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		if(x1 > x2 || x1 >= width || x2 >= width || 
			width < 0 || x1 < 0 || x2 < 0 || y < 0 || 
			width % 8 != 0 || y >= screen.length * 8 / width) {
			throw new IllegalArgumentException();
		}
		
		int byte1 = y * width / 8 + x1 / 8;
		int byte2 = y * width / 8 + x2 / 8;
		int bit1 = 7 - x1 % 8;
		int bit2 = 7 - x2 % 8;
		System.out.println("bit1: " + bit1);
		System.out.println("bit2: " + bit2);
		
		if(byte1 == byte2) {
			for(int i = bit2; i <= bit1; i++) {
				screen[byte1] = (byte) (screen[byte1] | (1 << i));
			}
			return screen;
		}
		
		for(int i = byte1 + 1; i < byte2; i++) {
			screen[i] = (~0);
		}
		
		for(int i = 0; i <= bit1; i++) {
			screen[byte1] = (byte) (screen[byte1] | (1 << i));
		}
		
		for(int i = 7; i >= bit2; i--) {
			screen[byte2] = (byte) (screen[byte2] | (1 << i));
		}
		
		return screen;
	}
}
