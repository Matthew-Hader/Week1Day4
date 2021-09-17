package com.ss.basics.line.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.ss.basics.line.Line;

/**
 * @author Matthew Hader
 *
 */
public class LineTest {
	
	Line vertLine = new Line(0.0, 0.0, 0.0, 5.0);
	Line negLine = new Line(-5.0, 0.0, 0.0, 0.0);
	Line line1 = new Line (0.0, 0.0, 5.0, 5.0);
	Line line2 = new Line (-5.0, 0.0, 0.0, 5.0);
	Line line3 = new Line (-5.0, 5.0, 0.0, 0.0);
	
	@Test
	public void getSlopeDivByZeroTest() {
		assertThrows(ArithmeticException.class, vertLine::getSlope);
	}
	
	@Test
	public void getDistanceNonNegTest() {
		assertTrue(negLine.getDistance() >= 0.0001 || negLine.getDistance() >= -0.0001);
	}
	
	@Test
	public void parallelToTrueTest() {
		assertTrue(line1.parallelTo(line2));
	}
	
	@Test
	public void parallelToFalseTest() {
		assertFalse(line1.parallelTo(line3));
	}
}
