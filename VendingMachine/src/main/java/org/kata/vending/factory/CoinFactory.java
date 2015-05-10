package org.kata.vending.factory;

import java.util.ArrayList;
import java.util.List;

import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.DimeCoin;
import org.kata.vending.busObjs.DollarCoin;
import org.kata.vending.busObjs.HalfDollarCoin;
import org.kata.vending.busObjs.NickelCoin;
import org.kata.vending.busObjs.PennyCoin;
import org.kata.vending.busObjs.QuarterCoin;
import org.kata.vending.busObjs.Tolerance;

public class CoinFactory {
	private static CoinFactory singleton = null;
	private List<CoinMetaData> coinTypes = new ArrayList<CoinMetaData>();

	public Coin create(double weight, double diameter, double thickness) {
		Coin rtn = null;
		for (CoinMetaData coinMetaData : coinTypes) {
			if (coinMetaData.isMatch(weight, diameter, thickness)) {
				rtn = coinMetaData.getCoin();
				break;
			}
		}
		return rtn;
	}

	public static CoinFactory getInstance() {
		if (singleton == null)
			singleton = new CoinFactory();
		return singleton;
	}

	protected CoinFactory() {
		coinTypes.add(new CoinMetaData(new Tolerance(2.5 * .9, 2.5 * 1.1),
				new Tolerance(19.05 * .9, 19.05 * 1.1), new Tolerance(
						1.52 * .9, 1.52 * 1.1), new PennyCoin()));
		coinTypes.add(new CoinMetaData(new Tolerance(5 * .9, 5 * 1.1),
				new Tolerance(21.21 * .9, 21.21 * 1.1), new Tolerance(
						1.95 * .9, 1.95 * 1.1), new NickelCoin()));
		coinTypes.add(new CoinMetaData(new Tolerance(2.268 * .9, 2.268 * 1.1),
				new Tolerance(17.91 * .9, 17.91 * 1.1), new Tolerance(
						1.35 * .9, 1.35 * 1.1), new DimeCoin()));
		coinTypes.add(new CoinMetaData(new Tolerance(5.67 * .9, 5.67 * 1.1),
				new Tolerance(24.26 * .9, 24.26 * 1.1), new Tolerance(
						1.75 * .9, 1.75 * 1.1), new QuarterCoin()));
		coinTypes.add(new CoinMetaData(new Tolerance(11.34 * .9, 11.34 * 1.1),
				new Tolerance(30.61 * .9, 30.61 * 1.1), new Tolerance(
						2.15 * .9, 2.15 * 1.1), new HalfDollarCoin()));
		coinTypes.add(new CoinMetaData(new Tolerance(8.1 * .9, 8.1 * 1.1),
				new Tolerance(26.49 * .9, 26.49 * 1.1), new Tolerance(2 * .9,
						2 * 1.1), new DollarCoin()));
	}
}
