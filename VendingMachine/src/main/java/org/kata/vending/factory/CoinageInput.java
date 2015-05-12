package org.kata.vending.factory;

public class CoinageInput extends VendingDeposit {
	private double diameter;
	private double thickness;
	private double weight;
	public CoinageInput(double weight, double diameter, double thickness) {
		setWeight(weight);
		setDiameter(diameter);
		setThickness(thickness);
	}
	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
