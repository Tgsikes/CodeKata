package org.kata.vending.busObjs;

public class Tolerance {

	private double lower;
	private double upper;

	public Tolerance(double lower, double upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public boolean withInTolerance(double value) {
		return value > lower && value < upper;
	}
}
