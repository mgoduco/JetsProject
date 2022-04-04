package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is loading cargo");

	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " can fly for " + (this.getRange() / this.getSpeed())
				+ " hours while flying at top speed!");
	}

	@Override
	public String toString() {
		return "CargoPlane Model: " + getModel() + ", Speed=" + getSpeed() + ", Range=" + getRange() + ", Price="
				+ getPrice();
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
