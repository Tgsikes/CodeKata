package org.kata.vending.factory;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.DimeCoin;
import org.kata.vending.busObjs.DollarCoin;
import org.kata.vending.busObjs.HalfDollarCoin;
import org.kata.vending.busObjs.NickelCoin;
import org.kata.vending.busObjs.PennyCoin;
import org.kata.vending.busObjs.QuarterCoin;

public class CoinFactoryTest {

	@Test
	public void FactoryReturnsPenney() {
		Coin coin = CoinFactory.getInstance().create(2.5, 19.05, 1.52);
		assertEquals(PennyCoin.class, coin.getClass());
		coin = CoinFactory.getInstance().create(5, 21.21, 1.95);
		assertEquals(NickelCoin.class, coin.getClass());
		coin = CoinFactory.getInstance().create(2.268, 17.91, 1.35);
		assertEquals(DimeCoin.class, coin.getClass());
		coin = CoinFactory.getInstance().create(5.67, 24.26, 1.75);
		assertEquals(QuarterCoin.class, coin.getClass());
		coin = CoinFactory.getInstance().create(11.34, 30.61, 2.15);
		assertEquals(HalfDollarCoin.class, coin.getClass());
		coin = CoinFactory.getInstance().create(8.1, 26.49, 2);
		assertEquals(DollarCoin.class, coin.getClass());
	}
}
