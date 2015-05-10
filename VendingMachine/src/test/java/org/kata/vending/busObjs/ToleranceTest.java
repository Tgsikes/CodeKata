package org.kata.vending.busObjs;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToleranceTest {

	@Test
	public void toleranceRtnsFalsewhnExceeded() {
		Tolerance target = new Tolerance(1, 10);
		assertFalse(target.withInTolerance(0));
		assertFalse(target.withInTolerance(10.1));
		assertTrue(target.withInTolerance(5));
	}

}
