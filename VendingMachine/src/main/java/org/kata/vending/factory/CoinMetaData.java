package org.kata.vending.factory;

import org.kata.vending.busObjs.Coin;
import org.kata.vending.busObjs.Tolerance;

public class CoinMetaData {
	private Tolerance diameter;
	private Coin template;
	private Tolerance thickness;
	private Tolerance weight;

	public CoinMetaData(Tolerance weight, Tolerance diameter,
			Tolerance thickness, Coin template) {
		this.setDiameter(diameter);
		this.setThickness(thickness);
		this.setWeight(weight);
		this.setTemplate(template);
	}

	public Tolerance getDiameter() {
		return diameter;
	}

	public Coin getTemplate() {
		return template;
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

	public void setTemplate(Coin template) {
		this.template = template;
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

	public Coin getCoin() {
		Coin rtn = null;
		try {
			rtn = getTemplate().getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return rtn;
	}

}
