
public class Flight {

	private City origin;
	private City destination;
	private int price;
	
	/**
     * Constructor
     * @param City of origin, city of destination, and price of flight
     * @return none
     */
	public Flight(City origin, City destination, int price) {
		this.origin = origin;
		this.destination = destination;
		this.price = price;
	}
	
	/**
     * Returns city object of origin
     * @param none
     * @return city object
     */
	public City getOrigin() {
		return origin;
	}
	
	/**
     * Returns city object of destination
     * @param none
     * @return city object
     */
	public City getDestination() {
		return destination;
	}
	
	/**
     * Returns price
     * @param none
     * @return int price
     */
	public int getPrice() {
		return price;
	}
}
