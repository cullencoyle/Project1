import java.util.ArrayList;
import java.util.List;

public class FlightMap {

	private char startCity;
	private List<City> cityList = new ArrayList<City>();
	private List<String> output = new ArrayList<String>();
	
	/**
     * Function that creates the flight routes from one city to another. Basically creates
     * the graph.
     * @param character associated with both the origin and the destination as well
     * as the price of the flight
     * @return no return. void
     */
	public void parseFlight(char origin, char dest, int price) {
		
		// initializations
		City city1 = null;
		City city2 = null;
		Flight newFlight;

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
		newFlight = new Flight(city1, city2, price);
		city1.addFlight(newFlight);

	}

	/**
     * The Depth First Search algorithm through the map. Recursively goes through map
     * @param City object of the current city as well as the path taken and the price of that flight
     * @return No return. void
     */
	public void DFS(City city, String currPath, int price) {

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

	/**
     * Creates a new city and adds it to the list of existing cities
     * @param character of the city being represented
     * @return returns the city object created
     */
	public City createCity(char s) {
		//System.out.println("Created City: " + s);
		City newCity = new City(s);
		cityList.add(newCity);
		return newCity;
	}

	/**
     * Searches through the list of cities and returns the city object associated with that
     * character, assuming a character can represent at most one city object
     * @param character of the city you are trying to get
     * @return returns the city object associated with that character
     */
	public City getCity(char cityLetter) {

		for (int i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getCity() == cityLetter) {
				return cityList.get(i);
			}
		}

		// never reached
		return null;
	}

	/**
     * Finds out if a city already has been established
     * @param character of the city you are trying to find out
     * @return returns true of it already exists, false if it is a new city
     */
	public boolean containsCity(char cityLetter) {

		for (int i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getCity() == cityLetter) {
				return true;
			}
		}
		return false;

	}

	/**
     * Adds to the list of strings used to output to the outputfile.txt
     * @param character of the city
     * @return A string correctly formatted with the path and cost to the destination.
     */
	public void outputFlight(char city, String currPath, int price) {

		String path = String.format("%-15s %-25s %-10s\n", city, currPath, "$" + price);
		output.add(path);
	}

	/**
     * Sets the starting city object when traversing through the map
     * @param character of the city
     * @return no return. void
     */
	public void setStartCity(char startCity) {
		this.startCity = startCity;		
	}
	
	/**
     * Get the character of the starting city
     * @param none
     * @return character of the starting city
     */
	public char getStartCity() {
		return startCity;
	}
	
	/**
     * Returns the list of strings for printing to the outputfile.txt
     * @param none
     * @return List of strings
     */
	public List<String> getOutput(){
		return output;
	}
}
