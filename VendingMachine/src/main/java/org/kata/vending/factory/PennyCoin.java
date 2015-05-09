package org.kata.vending.factory;

import org.kata.vending.busObjs.Coin;

public class PennyCoin extends Coin {

	public static boolean weightTolerance(double weight) {
		return withinTolerance(weight, 2.4, 2.6);
	}

	public static boolean diaTolerance(double diameter) {
		return withinTolerance(diameter, .74, .76);
	}

	public static boolean thicknessTolerance(double thickness) {
		return withinTolerance(thickness, 1.51, 1.53);
	}

	private static boolean withinTolerance(double coinSpec, double lower,
			double upper) {
		return coinSpec < upper && coinSpec > lower;
	}
}
