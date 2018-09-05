import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileManager {

	// reads the input file into a list of strings
	public static List<String> readFromFile(String filename) {
		List<String> requests = Collections.emptyList();
		try {
			requests = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
		}

		catch (IOException e) {
			System.out.println("An IOException occurred!!!");
			e.printStackTrace();
		}
		return requests;
	}

	// writes the result to the output file
	public static void writeResultToFile(List<String> result, String filename) {
		Path out = Paths.get(filename);
		try {
			Files.write(out, result, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error occurred while writing the file");
			e.printStackTrace();
		}

	}

}
