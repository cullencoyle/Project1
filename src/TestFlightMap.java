import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestFlightMap {

	FlightMap flightTest = new FlightMap();
	
	@Test
	public void parseFlightTest() {
		flightTest.parseFlight('A', 'B', 200);
		char cityDest = flightTest.getCity('A').getOutGoingFlights().get(0).getDestination().getCity();
		assertTrue('B' == cityDest);
	}
	
	@Test
	public void createCityTest() {
		flightTest.createCity('H');
		assertTrue(true == flightTest.containsCity('H'));
	}

	@Test
	public void getCityTest() {
		char x = 'X';
		flightTest.createCity(x);
		assertTrue('X' == flightTest.getCity(x).getCity() );
	}
	
	@Test
	public void containsCityTest() {
		assertTrue(false == flightTest.containsCity('Q'));
	}
	
	@Test
	public void outputFlightTest() {
		char city = 'F';
		String currPath = "A,B,C,F";
		int price = 800;
		String path = String.format("%-15s %-25s %-10s\n", city, currPath, "$" + price);
		flightTest.outputFlight('F', "A,B,C,F", 800);
		String otherPath = flightTest.getOutput().get(0);
		
		assertTrue(path.equals(otherPath));
	}
	
	@Test
	public void setStartCityTest() {
		flightTest.setStartCity('A');
		assertTrue(flightTest.getStartCity() == 'A');
	}
	
	@Test
	public void getStartCityTest() {
		flightTest.setStartCity('A');
		assertTrue(flightTest.getStartCity() == 'A');
	}
	
}
