import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * /** Brief description of the code
 * 
 * @author Cullen Coyle ITP 368, Fall 2018 Assignment 00 cullenco@usc.edu
 * 
 */
public class SearchMap {

	private static char startCity;
	private static PrintWriter writer;
	private static List<City> cityList = new ArrayList<City>();

	public static void main(String[] args) {

		// handle arguments and read file
		readInFile(args[0]);
		try {
			writer = new PrintWriter(args[1], "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String currPath = "";
		getCity(startCity).setVisited(true);
		writer.printf("%-15s %-25s %-10s\n", "Destination", "Flight Route From " + startCity, "Total Cost");
		DFS(getCity(startCity), currPath, 0);
		writer.close();
	}

	// read the inputfile.txt
	private static void readInFile(String inputFile) {

		File file = new File(inputFile);
		BufferedReader br = null;

		try {
			// set up to read text file
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;

			// get start city and create new city instance
			line = br.readLine();
			startCity = line.charAt(0);
			createCity(startCity);

			// creating all the flights
			while ((line = br.readLine()) != null) {
				String[] parse = line.split(" ");
				parseFlight(parse[0].charAt(0), parse[1].charAt(0), Integer.parseInt(parse[2]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + file.toString());
		}

	}

	private static void parseFlight(char origin, char dest, int price) {

		// initializations
		City city1 = null;
		City city2 = null;
		FlightMap newFlight;

		// if the city hasn't been established yet, create it.
		// Else, set the cities to the proper variables
		if (containsCity(origin) == false) {
			city1 = createCity(origin);
		} else {
			city1 = getCity(origin);
		}
		if (containsCity(dest) == false) {
			city2 = createCity(dest);
		} else {
			city2 = getCity(dest);
		}

		// create flight and add it to outgoing from origin
		newFlight = new FlightMap(city1, city2, price);
		city1.addFlight(newFlight);

	}

	private static void DFS(City city, String currPath, int price) {

		// BASE CASE
		if (city.isVisited() == true && city.getCity() != startCity) {
			return;
		}
		
		//new path to city
		if (city.isVisited() == false) {
			// get current path to this city
			outputFlight(city.getCity(), currPath + city.getCity(), price);
			city.setVisited(true);
		}

		//if there are no connecting flights, just return
		if (city.getOutGoingFlights().isEmpty() == true) {
			// end of path
			return;
		}
		
		//else, go through all the outgoing flights
		for (int i = 0; i < city.getOutGoingFlights().size(); i++) {

			City nextCity = city.getOutGoingFlights().get(i).getDestination();
			String nextPath = currPath + city.getCity() + ", ";
			int nextPrice = price + city.getOutGoingFlights().get(i).getPrice();

			DFS(nextCity, nextPath, nextPrice);
		}
	}

	//create a new City instance
	private static City createCity(char startCity) {
		City newCity = new City(startCity);
		cityList.add(newCity);
		return newCity;
	}

	//get a city object from the list of cities based on city letter
	private static City getCity(char cityLetter) {

		for (int i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getCity() == cityLetter) {
				return cityList.get(i);
			}
		}

		// never reached
		return null;
	}

	//returns true if the city has been established, false if not
	private static boolean containsCity(char cityLetter) {

		for (int i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getCity() == cityLetter) {
				return true;
			}
		}
		return false;

	}

	//print details of flight from A to B to the outputfile.txt
	private static void outputFlight(char city, String currPath, int price) {

		writer.printf("%-15s %-25s %-10s\n", city, currPath, "$" + price);
	}

}
