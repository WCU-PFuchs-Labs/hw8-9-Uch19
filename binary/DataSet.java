package binary;
import java.util.*;
import java.io.*;
/**
 * Author:
 * Date:
 * Purpose:
 */

import java.util.ArrayList;

public class DataSet {

    // add fields here
    private ArrayList<DataRow> data;
    private int numIndepVariables;
    /**
     * @param filename the name of the file to read the data set from
     */
       public DataSet(String filename)
    {
        data = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filename));

            // Read the first line (variable names)
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                String[] headerParts = header.split(",");

                // y is first, then the rest are independent x values
                numIndepVariables = headerParts.length - 1;
            }

            // Read the data lines
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) continue; // skip empty lines

                String[] parts = input.split(",");

                // Basic error handling: skip lines with missing columns
                if (parts.length < numIndepVariables + 1) {
                    continue;
                }

                // First value = y (dependent)
                double y = Double.parseDouble(parts[0].trim());

                // Remaining values = x values (independent)
                double[] x = new double[numIndepVariables];
                for (int i = 0; i < numIndepVariables; i++) {
                    x[i] = Double.parseDouble(parts[i + 1].trim());
                }

                data.add(new DataRow(y, x));
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
    

    /**
     * @return the list of rows
     */
    public ArrayList<DataRow> getRows() {
        // FIXME: return the right thing here
        return data;
    }

    /**
     * @return the number of independent variables in each row of the data set
     */
    public int getNumIndependentVariables() {
        // FIXME: return the right thing here
        return numIndepVariables;
    }
}
