import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SearchMap {

	private static char startCity;
	private static PrintWriter writer;

	public static void main(String[] args) {

		FlightMap newFlightMap = new FlightMap();
		// handle arguments and read file
		readInFile(args[0], newFlightMap);
		try {
			writer = new PrintWriter(args[1], "UTF-8");
			//newFlightMap.setWriter(writer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String currPath = "";
		newFlightMap.getCity(startCity).setVisited(true);
		writer.printf("%-15s %-25s %-10s\n", "Destination", "Flight Route From " + startCity, "Total Cost");
		newFlightMap.DFS(newFlightMap.getCity(startCity), currPath, 0);
		
		List<String> output = newFlightMap.getOutput();
		for(int i = 0; i < output.size(); i++) {
			writer.print(output.get(i));
		}
		
		writer.close();
	}

	/**
     * Reads the file provided by the user
     * @param String of the input file name and the flightMap that holds the entire map
     * @return No return
     */
	private static void readInFile(String inputFile, FlightMap newFlightMap) {

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
			newFlightMap.setStartCity(startCity);
			newFlightMap.createCity(startCity);

			// creating all the flights
			while ((line = br.readLine()) != null) {
				String[] parse = line.split(" ");
				newFlightMap.parseFlight(parse[0].charAt(0), parse[1].charAt(0), Integer.parseInt(parse[2]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + file.toString());
		}

	}

}
