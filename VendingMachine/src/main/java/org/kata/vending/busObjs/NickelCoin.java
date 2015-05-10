package org.kata.vending.busObjs;


public class NickelCoin extends Coin {
	private static  Tolerance wght = new Tolerance(4.9, 5.1);
	private static  Tolerance dia = new Tolerance(.825, .845);
	private static  Tolerance thick = new Tolerance(1.85, 2.05);

	public static  boolean inTollerance(double weight, double diameter,
			double thickness) {
		return wght.withInTolerance(weight) && dia.withInTolerance(diameter)
				&& thick.withInTolerance(thickness);
	}
}
