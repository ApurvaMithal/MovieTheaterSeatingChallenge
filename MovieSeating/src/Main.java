import java.util.List;

public class Main {

	// main function
	public static void main(String[] args) {

		// call to read the input file into list of String
		List<String> requests = FileManager.readFromFile(args[0]);
	
		// creating an MovieTheatre object
		MovieTheater obj = new MovieTheater();
		// call to allotSeat function that returns the result of seat allotment as list
		// of String
		List<String> result = obj.allotSeat(requests);

		// call to write the result into the output file.
		FileManager.writeResultToFile(result, args[1]);

	}

}
