import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTheater {

	private static final int ROWS = 10; // no of rows
	private static final int COLS = 20; // no of seats in each row

	// function to allot the seats
	public List<String> allotSeat(List<String> requests) {

		int lastProcessedRow = -1;
		int remainingSeat[] = new int[ROWS];
		Arrays.fill(remainingSeat, COLS);
		List<String> result = new ArrayList<String>();

		// loop to process each request at a time
		for (int i = 0; i < requests.size(); i++) {
			int j = 0;
			int min = COLS + 1, indx = 0;
			int startCol = 0, endCol = 0, rowNo = 0;
			int reqSeats = Integer.parseInt(requests.get(i).split(" ")[1]);
			String output = requests.get(i).split(" ")[0] + " ";

			// loop to find the best possible row among the rows currently processed that
			// supports maximum utilization
			for (j = 0; j <= lastProcessedRow; j++) {
				if ((remainingSeat[j] >= reqSeats) && ((remainingSeat[j] - reqSeats) < min)) {
					min = remainingSeat[j] - reqSeats;
					indx = j;
				}
			}

			// condition when the whole group cannot be seated together among the currently
			// processed rows
			if (min == COLS + 1) {

				// condition when the whole group cannot be seated together in the entire
				// theater hall
				if (lastProcessedRow == ROWS - 1) {
					int k = 0, temp = reqSeats;
					// loop to split the group in different rows
					while (k <= lastProcessedRow && temp > 0) {
						if (remainingSeat[k] > 0) {
							rowNo = k;
							if (remainingSeat[k] <= temp) {
								startCol = COLS - remainingSeat[k] + 1;
								endCol = COLS;
								output = buildOutput(output, startCol, endCol, rowNo);
								temp -= remainingSeat[k];
								if (temp > 0) {
									output += ",";
								}
								remainingSeat[k] = 0;
							} else {
								startCol = COLS - remainingSeat[k] + 1;
								endCol = startCol + temp - 1;
								output = buildOutput(output, startCol, endCol, rowNo);
								remainingSeat[k] -= temp;
								temp = 0;
							}
						}
						k++;
					}

				}
				// condition when the whole group needs to be seated in a new row
				else {
					lastProcessedRow++;
					rowNo = lastProcessedRow;
					startCol = 1;
					endCol = reqSeats;
					remainingSeat[lastProcessedRow] -= reqSeats;
					output = buildOutput(output, startCol, endCol, rowNo);
				}
			}
			// condition when the whole group can be seated in one of the rows among the
			// currently processed rows
			else {
				rowNo = indx;
				startCol = COLS - remainingSeat[indx] + 1;
				endCol = COLS - remainingSeat[indx] + reqSeats;
				remainingSeat[indx] -= reqSeats;
				output = buildOutput(output, startCol, endCol, rowNo);
			}
		//	System.out.println(output);

			result.add(output);
		}
		return result;
	}

	// Function to build the output String
	String buildOutput(String output, int startCol, int endCol, int rowNo) {

		for (int k = startCol; k < endCol; k++) {
			output += (char) (rowNo + 'A');
			output += String.valueOf(k) + ",";
		}
		output += (char) (rowNo + 'A') + String.valueOf(endCol);
		return output;
	}

}
