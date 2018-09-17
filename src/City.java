import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
/**
 * Brief description of the code
 * 
 * @author Cullen Coyle
 * ITP 368, Fall 2018
 * Assignment 03
 * cullenco@usc.edu

 */
public class City {
	
	List<Flight> outGoingFlights;
	char city;
	boolean visited;
	
	public City(char city) {
		this.city = city;
		outGoingFlights = new ArrayList<Flight>();
		visited = false;
		
	}
	
	public void addFlight(Flight newFlight) {
		outGoingFlights.add(newFlight);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Flight> getOutGoingFlights() {
		return outGoingFlights;
	}

	public char getCity() {
		return city;
	}
	
	

}
