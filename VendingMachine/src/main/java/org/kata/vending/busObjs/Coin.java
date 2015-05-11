package org.kata.vending.busObjs;

public class Coin {

	private double value;
	public Coin(double value) {
		setValue(value);
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

}
