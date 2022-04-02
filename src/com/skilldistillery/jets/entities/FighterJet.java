package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "FighterJet [getModel()=" + getModel() + ", getSpeed()=" + getSpeed() + ", getRange()=" + getRange()
				+ ", getPrice()=" + getPrice() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
