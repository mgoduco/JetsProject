package com.skilldistillery.jets.entities;

public class PassengerPlane extends Jet {

	public PassengerPlane() {
	}

	public PassengerPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours while flying at top speed!");
	}


	@Override
	public String toString() {
		return "PassengerPlane Model: " + getModel() + ", Speed=" + getSpeed() + ", Range=" + getRange()
				+ ", Price=" + getPrice() ;
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
