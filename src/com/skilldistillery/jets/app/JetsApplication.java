package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.PassengerPlane;

public class JetsApplication {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		jetsApp.fillAirField(jetsApp);
		jetsApp.run(jetsApp);
	}

	public void run(JetsApplication jetsApp) {
		AirField airField = new AirField();
		jetsApp.displayMenu(jetsApp, airField);

	}

	public void displayMenu(JetsApplication jetsApp, AirField airField) {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println("1.List Fleet");
			System.out.println("2.Fly all jets");
			System.out.println("3.View fastest jet");
			System.out.println("4.View jet with longest range");
			System.out.println("5.Load all Cargo Jets");
			System.out.println("6.Dogfight!");
			System.out.println("7.Add a jet to Fleet");
			System.out.println("8.Remove a jet from Fleet");
			System.out.println("9. Quit  ");

			int input = sc.nextInt();
			switch (input) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:
				System.out.println();
				System.exit(0);
				break;

			default:
				break;
			}

		}

	}

	// User Story #3
	private AirField fillAirField(JetsApplication jetsApp) {
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

//	private void writePlanets(String outFileName, AirField airfield) {	// User Story #15
//		try {
//			FileWriter fw = new FileWriter(outFileName);
//			PrintWriter pw = new PrintWriter(fw);
//			for (AirField index : airfield) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(index.getModel());
//				sb.append('\t');
//				sb.append(index.getSpeed());
//				sb.append('\t');
//				sb.append(index.getRange());
//				sb.append('\t');
//				sb.append(index.getPrice());
//				pw.println(sb);
//			}
//			pw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}