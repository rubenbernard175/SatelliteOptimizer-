/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.Arrays;

/**
 * SatelliteOptimizer
 * Greedy algorithm to get the max scientific value possible
 * within a given capacity limit.
 * COP3503C
 * Ruben Bernard
 * OH hint, plus TA hint
 * 5583850
 */
public class SatelliteOptimizer {

    private static class Packet {
        int size;
        int value;
        double ratio;

        Packet(int size, int value) {
            this.size = size; // packet's size in MB
            this.value = value;
            this.ratio = (double) value / size; // calculates packet's value per MB
        }
    }

    public static double maximizeScientificValue(int[] sizes, int[] values, int capacity) {

        if (sizes == null || values == null || sizes.length != values.length || capacity <= 0) {
            return 0.0; // if something’s off, just return 0
        }

        int n = sizes.length;
        Packet[] packets = new Packet[n]; // store all packets here

        for (int i = 0; i < n; i++) {
            packets[i] = new Packet(sizes[i], values[i]); // creates each packet
        }

        Arrays.sort(packets, (a, b) -> Double.compare(b.ratio, a.ratio));
        // sorts by value per MB (highest first)

        double totalValue = 0.0;
        int remaining = capacity; // how much space is left

        for (Packet p : packets) {
            if (remaining == 0) break; // stop when it’s full

            if (p.size <= remaining) {
                totalValue += p.value; // add full packet’s value
                remaining -= p.size;
            } else {
                totalValue += p.ratio * remaining; // take what’s left proportionally
                remaining = 0;
            }
        }

        totalValue = Math.round(totalValue * 100.0) / 100.0; // round to 2 decimals
        return totalValue; // final total scientific value
    }
}