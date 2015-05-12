package org.kata.vending.factory;

import org.kata.vending.busObjs.Tolerance;

public class CoinMetaData {
	private Tolerance diameter;
	private double value;
	private Tolerance thickness;
	private Tolerance weight;

	public CoinMetaData(double lowerWeight, double upperWeight,
			double lowerDiameter, double upDiameter, double lowerThickness,
			double upperThickness, double value) {
		this(new Tolerance(lowerWeight, upperWeight), new Tolerance(
				lowerDiameter, upDiameter), new Tolerance(lowerThickness,
				upperThickness), value);
	}

	public CoinMetaData(Tolerance weight, Tolerance diameter,
			Tolerance thickness, double value) {
		this.setDiameter(diameter);
		this.setThickness(thickness);
		this.setWeight(weight);
		this.setValue(value);
	}

	public Tolerance getDiameter() {
		return diameter;
	}

	public Tolerance getThickness() {
		return thickness;
	}

	public Tolerance getWeight() {
		return weight;
	}

	public void setDiameter(Tolerance diameter) {
		this.diameter = diameter;
	}

	public void setThickness(Tolerance thickness) {
		this.thickness = thickness;
	}

	public void setWeight(Tolerance weight) {
		this.weight = weight;
	}

	public boolean isMatch(double weight, double diameter, double thickness) {
		return getWeight().withInTolerance(weight)
				&& getDiameter().withInTolerance(diameter)
				&& getThickness().withInTolerance(thickness);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rtn = false;
		if (obj instanceof CoinageInput) {
			CoinageInput coininput = (CoinageInput)obj;
			rtn = getWeight().withInTolerance(coininput.getWeight())
					&& getDiameter().withInTolerance(coininput.getDiameter())
					&& getThickness().withInTolerance(coininput.getThickness());
		}
		else
		{
			throw new UnsupportedOperationException();
		}
		return rtn;
	}

}
