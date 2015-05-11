package org.kata.vending.factory;

import java.util.ArrayList;
import java.util.List;

import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.Tolerance;

public class CoinFactory {
	private static CoinFactory singleton = null;
	private List<CoinMetaData> coinTypes;;

	public List<CoinMetaData> getCoinTypes() {
		if (coinTypes == null)
			coinTypes = new ArrayList<CoinMetaData>();
		return coinTypes;
	}

	public void setCoinTypes(List<CoinMetaData> coinTypes) {
		this.coinTypes = coinTypes;
	}

	public Coin create(double weight, double diameter, double thickness) {
		Coin rtn = null;
		for (CoinMetaData coinMetaData : coinTypes) {
			if (coinMetaData.isMatch(weight, diameter, thickness)) {
				rtn = new Coin(coinMetaData.getValue());
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

	public CoinFactory() {
		getCoinTypes().add(new CoinMetaData(2.5,2.5,19.05,19.05,1.52,1.52, .01 ));
		getCoinTypes().add(new CoinMetaData(new Tolerance(5 * .9, 5 * 1.1),
				new Tolerance(21.21 * .9, 21.21 * 1.1), new Tolerance(
						1.95 * .9, 1.95 * 1.1), .05));
		getCoinTypes().add(new CoinMetaData(new Tolerance(2.268 * .9, 2.268 * 1.1),
				new Tolerance(17.91 * .9, 17.91 * 1.1), new Tolerance(
						1.35 * .9, 1.35 * 1.1), .10));
		getCoinTypes().add(new CoinMetaData(new Tolerance(5.67 * .9, 5.67 * 1.1),
				new Tolerance(24.26 * .9, 24.26 * 1.1), new Tolerance(
						1.75 * .9, 1.75 * 1.1), .25));
		getCoinTypes().add(new CoinMetaData(new Tolerance(11.34 * .9, 11.34 * 1.1),
				new Tolerance(30.61 * .9, 30.61 * 1.1), new Tolerance(
						2.15 * .9, 2.15 * 1.1), .5));
		getCoinTypes().add(new CoinMetaData(new Tolerance(8.1 * .9, 8.1 * 1.1),
				new Tolerance(26.49 * .9, 26.49 * 1.1), new Tolerance(2 * .9,
						2 * 1.1), 1));
	}
}
