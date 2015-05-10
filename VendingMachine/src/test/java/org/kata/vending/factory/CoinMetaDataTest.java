package org.kata.vending.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kata.vending.busObjs.PennyCoin;
import org.kata.vending.busObjs.Tolerance;

public class CoinMetaDataTest {
	@Test
	public void CoinMetaData() {
		CoinMetaData cmd = new CoinMetaData(new Tolerance(2.5 * .9, 2.5 * 1.1),
				new Tolerance(21.21 * .9, 21.21 * 1.1), new Tolerance(
						1.95 * .9, 1.95 * 1.1), new PennyCoin());

		assertTrue(cmd.isMatch(2.5, 21.21, 1.95));
		assertEquals(PennyCoin.class,cmd.getCoin().getClass());

	}

}
