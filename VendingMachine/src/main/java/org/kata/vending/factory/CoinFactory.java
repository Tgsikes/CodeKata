package org.kata.vending.factory;

import org.kata.vending.busObjs.Coin;

public class CoinFactory {

	public static Coin create(double weight, double diameter, double thickness) {
		Coin aCoin = null;
		if (PennyCoin.weightTolerance(weight) && PennyCoin.diaTolerance(diameter) && PennyCoin.thicknessTolerance(thickness))
		aCoin = new PennyCoin();
		return aCoin;
	}

}
