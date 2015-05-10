package org.kata.vending.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kata.vending.busObjs.Coin;

public class CoinFactoryTest {

	@Test
	public void FactoryReturnsPenney() {
		Coin coin = CoinFactory.getInstance().create(2.5, 19.05, 1.52);
		assertEquals(PennyCoin.class, coin.getClass());
	}
}
