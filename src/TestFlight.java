import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFlight {

	@Test
	public void getOriginTest() {
		City newCity1 = new City('A');
		City newCity2 = new City('B');
		Flight newFlight = new Flight(newCity1, newCity2, 200);
		
		assertTrue(newFlight.getOrigin().getCity() == 'A');
	}
	
	@Test
	public void getDestinationTest() {
		City newCity1 = new City('X');
		City newCity2 = new City('Y');
		Flight newFlight = new Flight(newCity1, newCity2, 200);
		
		assertTrue(newFlight.getDestination().getCity() == 'Y');
	}
	
	@Test
	public void getPriceTest() {
		City newCity1 = new City('A');
		City newCity2 = new City('B');
		Flight newFlight = new Flight(newCity1, newCity2, 500);
		
		assertTrue(newFlight.getPrice() == 500);
	}

}
