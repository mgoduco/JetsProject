package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.PassengerPlane;

public class JetsApplication {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.run(jetsApp);
	}

	public void run(JetsApplication jetsApp) {
		AirField airField = jetsApp.fillAirField(jetsApp);
		jetsApp.displayMenu(jetsApp, airField);
	}

	public void displayMenu(JetsApplication jetsApp, AirField airField) {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("Please select an option from below");
			System.out.println("1.List Fleet");
			System.out.println("2.Fly all jets");
			System.out.println("3.View fastest jet");
			System.out.println("4.View jet with longest range");
			System.out.println("5.Load all Cargo Jets");
			System.out.println("6.Dogfight!");
			System.out.println("7.Add a jet to Fleet");
			System.out.println("8.Remove a jet from Fleet");
			System.out.println("9. Quit  ");

			int option = jetsApp.option();
			switch (option) {
			case 1:
				listFleet(airField);
				break;
			case 2:
				flyAllJets(airField);
				break;
			case 3:
				viewFastestJet(airField);
				break;
			case 4:
				viewLongestRange(airField);
				break;
			case 5:
				loadCargoJets(airField);
				break;
			case 6:
				dogFight(airField);
				break;
			case 7:
				addJet(airField);
				break;
			case 8:
				removeJet(airField);
				break;
			case 9:	
				// User Story #11
				System.out.println("Goodbye");
				System.exit(0);
				break;

			default:
				break;
			}

		}

	}

	public int option() {
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}

	public void listFleet(AirField airField) {
		for (int i = 0; i < airField.getJets().size(); i++) {
			System.out.println(airField.getJets().get(i).toString());
		}
	}
	// User Story #6
	public void flyAllJets(AirField airField) {
		for (int i = 0; i < airField.getJets().size(); i++) {
			airField.getJets().get(i).fly();
		}
	}
	// User Story #7
	private void viewFastestJet(AirField airField) {
		double speed = 0;
		int index = 0;
		for (int i = 0; i < airField.getJets().size(); i++) {
			if (airField.getJets().get(i).getSpeed() > speed) {
				speed = airField.getJets().get(i).getSpeed();
				index = i;
			}
		}
		System.out.println("This jet is the fastest: " +airField.getJets().get(index).toString());
	}
	// User Story #7
	private void viewLongestRange(AirField airField) {
		int range = 0;
		int index = 0;
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i).getRange() > range) {
				range = airField.getJets().get(i).getRange();
				index = i;
			}
		}
		System.out.println("This jet has the longest range: " + airField.getJets().get(index).toString());
	}
	// User Story #8
	private void loadCargoJets(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i) instanceof CargoCarrier) {
				((CargoCarrier) airField.getJets().get(i)).loadCargo();
			}
		}
	}

	private void dogFight(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i) instanceof CombatReady) {
				((CombatReady) airField.getJets().get(i)).dogFight();
			}
		}
	}
	// User Story #9
	private void addJet(AirField airField) {
		System.out.println("Which jet would you like to add?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Passenger Plane");
		int option = option();
		System.out.println("Enter the model: ");
		String model = sc.nextLine();
		System.out.println("Enter the speed (in MPH): ");
		double speed = sc.nextDouble();
		System.out.println("Enter the range: ");
		int range = sc.nextInt();
		System.out.println("Enter the price: ");
		long price = sc.nextLong();
		
		if(option == 1) {
			FighterJet jet = new FighterJet(model, speed, range, price);
			airField.addJet(jet);
		} else if (option == 2) {
			CargoPlane jet = new CargoPlane(model, speed, range, price);
			airField.addJet(jet);
		} else if (option == 3) {
			PassengerPlane jet = new PassengerPlane(model, speed, range, price);
			airField.addJet(jet);
		}
	}
	// User Story #10
	private void removeJet(AirField airField) {
		System.out.println("Remove jet by: ");
		System.out.println("1. Number");
		System.out.println("2. Name");
		int option = option();
		switch(option) {
		case 1:
			removeJetByNumber(airField);
			break;
		case 2:
			removeJetByName(airField);
			break;
		}
	}

	public void removeJetByNumber(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			System.out.println((i+1) + ". ");
			System.out.println(airField.getJets().get(i).toString());
		}
		System.out.println("Select a jet to remove: ");
		int option = option();
		airField.getJets().remove(option-1);
		System.out.println();
		
	}
	
	public void removeJetByName(AirField airField) {
		for(int i=0; i<airField.getJets().size(); i++) {
			System.out.println(airField.getJets().get(i).toString());
		}
		System.out.println("Type the model of the jet to remove:");
		String option = sc.nextLine();
		for(int i=0; i<airField.getJets().size(); i++) {
			if(option.equalsIgnoreCase(airField.getJets().get(i).getModel())) {
				airField.getJets().remove(i);
			}
		}
	}
	// User Story #3
	public AirField fillAirField(JetsApplication jetsApp) {
		AirField airField = new AirField();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetRecord = line.split(",");
				String model = jetRecord[1];
				double speed = Double.parseDouble(jetRecord[2]);
				int range = Integer.parseInt(jetRecord[3]);
				long price = Long.parseLong(jetRecord[4]);
				if (jetRecord[0].equalsIgnoreCase("FighterJet")) {
					FighterJet jet = new FighterJet(model, speed, range, price);
					airField.addJet(jet);
				} else if (jetRecord[0].equalsIgnoreCase("CargoPlane")) {
					CargoPlane jet = new CargoPlane(model, speed, range, price);
					airField.addJet(jet);
				} else {
					PassengerPlane jet = new PassengerPlane(model, speed, range, price);
					airField.addJet(jet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return airField;
	}

}

