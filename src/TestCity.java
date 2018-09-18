import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCity {

	@Test
	public void cityTest() {
		City newCity = new City('A');
		assertTrue(newCity.getCity() == 'A');
	}
	
	@Test
	public void addFlightTest() {
		City newCity = new City('A');
		City newCity2 = new City('B');
		Flight newFlight = new Flight(newCity, newCity2, 300);
		
		assertTrue(newFlight.getOrigin().getCity() == 'A');
		assertTrue(newFlight.getDestination().getCity() == 'B');
		assertTrue(newFlight.getPrice() == 300);
	}
	
	@Test
	public void isVisitedTest() {
		City newCity = new City('A');
		newCity.setVisited(true);
		
		assertTrue(true == newCity.isVisited());
	}
	
	@Test
	public void setVisitedTest() {
		City newCity = new City('A');
		newCity.setVisited(false);
		
		assertTrue(false == newCity.isVisited());
	}
	
	@Test
	public void getOutgoingFlightsTest() {
		FlightMap newFlight = new FlightMap();
		newFlight.parseFlight('A', 'B', 200);
		
		assertTrue('B' == newFlight.getCity('A').getOutGoingFlights().get(0).getDestination().getCity());
		
	}
	
	@Test
	public void getCityTest() {
		City newCity = new City('A');
		assertTrue(newCity.getCity() == 'A');
		
	}

}
