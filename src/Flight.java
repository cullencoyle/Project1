/**
 * 
 */

/**
/**
 * Brief description of the code
 * 
 * @author Cullen Coyle
 * ITP 368, Fall 2018
 * Assignment 00
 * cullenco@usc.edu

 */
public class Flight {

	private City origin;
	private City destination;
	private int price;
	
	public Flight(City origin, City destination, int price) {
		this.origin = origin;
		this.destination = destination;
		this.price = price;
		
		System.out.println("Flight from " + origin.getCity() + " to " + destination.getCity() + " for $" + price);
	}
	public City getOrigin() {
		return origin;
	}
	public City getDestination() {
		return destination;
	}
	public int getPrice() {
		return price;
	}
}
