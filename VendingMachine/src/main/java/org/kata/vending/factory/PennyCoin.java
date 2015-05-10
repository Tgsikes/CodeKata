package org.kata.vending.factory;

import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.Tolerance;

public class PennyCoin extends Coin {
	private static  Tolerance wght = new Tolerance(2.4, 2.6);
	private static  Tolerance dia = new Tolerance(.74, .76);
	private static  Tolerance thick = new Tolerance(1.51, 1.53);

	public static  boolean inTollerance(double weight, double diameter,
			double thickness) {
		return wght.withInTolerance(weight) && dia.withInTolerance(diameter)
				&& thick.withInTolerance(thickness);
	}
}
