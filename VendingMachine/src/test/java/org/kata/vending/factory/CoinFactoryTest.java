package org.kata.vending.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kata.vending.busObjs.Coin;

public class CoinFactoryTest {

	@Test
	public void FactoryReturnsPenny() {
		Coin coin = CoinFactory.create(2.5, .75, 1.52);
		assertEquals(PennyCoin.class, coin.getClass());
	}
}
