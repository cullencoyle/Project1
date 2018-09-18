import java.util.ArrayList;
import java.util.List;

public class City {
	
	List<Flight> outGoingFlights;
	char city;
	boolean visited;
	
	/**
     * Constructor of city object
     * @param character representing city
     * @return none
     */
	public City(char city) {
		this.city = city;
		outGoingFlights = new ArrayList<Flight>();
		visited = false;
		
	}
	
	/**
     * Adds a flight to the list of outgoing flights associated with the city
     * @param flight outgoing from city
     * @return none
     */
	public void addFlight(Flight newFlight) {
		outGoingFlights.add(newFlight);
	}

	/**
     * Returns if the city has been visited or not, used for DFS search algorithm
     * @param none
     * @return true or false
     */
	public boolean isVisited() {
		return visited;
	}

	/**
     * Set the state of the visited city
     * @param boolean of the state: set to false by default so used to set to true
     * @return none
     */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
     * Returns the whole list of outgoing flights associated with the city
     * @param none
     * @return List of Flight objects
     */
	public List<Flight> getOutGoingFlights() {
		return outGoingFlights;
	}

	/**
     * Returns city character associated with city
     * @param none
     * @return character associated with city
     */
	public char getCity() {
		return city;
	}
	
	

}
