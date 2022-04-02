package com.skilldistillery.jets.entities;

public class PassengerPlane extends Jet {

	public PassengerPlane() {
	}

	public PassengerPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {

	}

	@Override
	public String toString() {
		return "PassengerPlane [getModel()=" + getModel() + ", getSpeed()=" + getSpeed() + ", getRange()=" + getRange()
				+ ", getPrice()=" + getPrice() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
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
