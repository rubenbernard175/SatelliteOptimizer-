import java.io.*;
import java.util.*;

public class SatelliteDriver {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java SatelliteDriver <input_file> <output_file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        Scanner sc = new Scanner(new File(inputFile));
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int[] sizes = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        sc.close();

        double result = SatelliteOptimizer.maximizeScientificValue(sizes, values, capacity);

        // Create output file if it doesn't exist        
        File output = new File(outputFile);        
        output.getParentFile().mkdirs(); // Create parent directories if needed
        
        PrintWriter out = new PrintWriter(outputFile);
        out.printf("%.2f\n", result);
        out.close();
    }
}
