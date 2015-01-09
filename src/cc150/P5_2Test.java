package cc150;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class P5_2Test {
	double r, r2, r3;
	
	@Before
	public void setUp() throws Exception {
		r = 0b0111011;
		r2 = 0b1111111111111111111111111111111; //31 bits
		r3 = r2 / 8;
		r = r / 8; //111.011
	}

	@Test
	public void testPrintBinary() {
		assertEquals(P5_2.printBinary(r), "111.011");
		assertEquals(P5_2.printBinary(0), "0.0");
		assertEquals(P5_2.printBinary(0b100), "100.0");
		assertEquals(P5_2.printBinary(Math.PI), "ERROR");
		assertEquals(P5_2.printBinary(r / 16), "0.0111011");
		assertEquals(P5_2.printBinary(r3), "1111111111111111111111111111.111");
		assertEquals(P5_2.printBinary(r2), "ERROR");
	}

}
