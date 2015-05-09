package org.kata.vending.factory;

import org.kata.vending.busObjs.Coin;

public class PennyCoin extends Coin {

	private static boolean testTolerance(double coinSpec, double lower,
			double upper) {
		return coinSpec < upper && coinSpec > lower;
	}

	public static boolean inTolerance(double weight, double diameter,
			double thickness) {
		return testTolerance(weight, 2.4, 2.6)
				&& testTolerance(diameter, .74, .76)
				&& testTolerance(thickness, 1.51, 1.53);
	}
}
