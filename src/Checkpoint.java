import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.function.Consumer;

public class Checkpoint {
	public static void main(String[] args) {
		/*
		 * The auto-mgp.data file contains the miles-per-gallon data on various
		 * different types of cars. Each line of the file provides the data for one
		 * CarMPGEntry object. (source: http://archive.ics.uci.edu/ml/datasets)
		 * 
		 * Use the method provided to get an ArrayList of CarMPGEntry objects. Convert
		 * the ArrayList into a Stream. Using streams, perform the following:
		 * 
		 * 1. Print the entire list.
		 * 
		 * 
		 * 2. Print the miles per gallon of each entry.
		 * 
		 * 
		 * 3. Print alphabetized car names of the list.
		 * 
		 * 
		 * 4. Print the list with all 8 cylinder cars removed.
		 * 
		 * 
		 * 5. Print only the cars with "toyota" in the name.
		 */

		ArrayList<CarMPGEntry> carList = readCarMPGEntryDataFromFile();
		Stream<CarMPGEntry> carStream = carList.stream();

		System.out.println("asdf");

		carStream.forEach((CarMPGEntry x) -> {

			System.out.print(x.mpg);
			System.out.print(" ");
			System.out.print(x.cylinders);
			System.out.print(" ");
			System.out.print(x.displacement);
			System.out.print(" ");
			System.out.print(x.horsePower);
			System.out.print(" ");
			System.out.print(x.weight);
			System.out.print(" ");
			System.out.print(x.acceleration);
			System.out.print(" ");
			System.out.print(x.modelYear);
			System.out.print(" ");
			System.out.print(x.origin);
			System.out.print(" ");
			System.out.print(x.carName);
			System.out.println();
			
			

		});

		
//		carStream = carList.stream();
//		carStream = carStream.sorted((CarMPGEntry x, CarMPGEntry y) -> x.carName.compareTo(y.carName));
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("NO 8 CYLINDER CARS");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		carStream = carList.stream();
		carStream = carStream.filter((CarMPGEntry x) -> !(x.cylinders == 8))
				.filter((CarMPGEntry x) -> (x.carName.contains("toyota")))
				.sorted((CarMPGEntry x, CarMPGEntry y) -> x.carName.compareTo(y.carName));
		carStream.forEach((CarMPGEntry x) -> {

			System.out.print(x.mpg);
			System.out.print(" ");
			System.out.print(x.cylinders);
			System.out.print(" ");
			System.out.print(x.displacement);
			System.out.print(" ");
			System.out.print(x.horsePower);
			System.out.print(" ");
			System.out.print(x.weight);
			System.out.print(" ");
			System.out.print(x.acceleration);
			System.out.print(" ");
			System.out.print(x.modelYear);
			System.out.print(" ");
			System.out.print(x.origin);
			System.out.print(" ");
			System.out.print(x.carName);
			System.out.println();

		});

	}

	public static ArrayList<CarMPGEntry> readCarMPGEntryDataFromFile() {
		ArrayList<CarMPGEntry> carList = new ArrayList<CarMPGEntry>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("auto-mpg.data"));

			String line = br.readLine();
			while (line != null) {
				String entry = "";
				ArrayList<String> splitEntry = new ArrayList<String>();
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == ' ' || c == '\t') {
						if (entry.length() > 0) {
							splitEntry.add(entry);
							entry = "";
						}
					} else if (c == '\"') {
						i++;
						c = line.charAt(i);
						while (c != '\"') {
							entry += c;
							c = line.charAt(++i);
						}
						splitEntry.add(entry);
					} else {
						entry += c;
					}
				}

				CarMPGEntry cmpg = new CarMPGEntry();

				cmpg.mpg = Float.parseFloat(splitEntry.get(0));
				cmpg.cylinders = Integer.parseInt(splitEntry.get(1));
				cmpg.displacement = Float.parseFloat(splitEntry.get(2));
				try {
					cmpg.horsePower = Float.parseFloat(splitEntry.get(3));

				} catch (NumberFormatException e) {
					cmpg.horsePower = -1;
				}
				cmpg.weight = Float.parseFloat(splitEntry.get(4));
				cmpg.acceleration = Float.parseFloat(splitEntry.get(5));
				cmpg.modelYear = Integer.parseInt(splitEntry.get(6));
				cmpg.origin = Integer.parseInt(splitEntry.get(7));
				cmpg.carName = splitEntry.get(8);
				carList.add(cmpg);

				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return carList;
	}

}
