package aliceNewGame;

import java.util.HashSet;
import java.util.Set;

public class main {

    public static void main(String[] args) {
    	String result42 = "NO";
        String line = "4 20 3 1 40";
        String[] tokens = line.split(" ");
        int[] values = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            values[i] = Integer.parseInt(tokens[i]);
        }
        Set<Integer> results = new HashSet<>();
        canReach42(values, 0, values[0], results);

        for (int result : results) {
            if(result == 42) {
            	result42 = "YES";
            }
        }
        
        System.out.println(result42);
    }

    public static void canReach42(int[] values, int index, int current, Set<Integer> results) {
        if (index == values.length - 1) {
            results.add(current);
            return;
        }
        // Try addition
        canReach42(values, index + 1, current + values[index + 1], results);
        // Try subtraction
        canReach42(values, index + 1, current - values[index + 1], results);
        // Try multiplication
        canReach42(values, index + 1, current * values[index + 1], results);
        // Try concatenation
        int next = values[index + 1];
        canReach42(values, index + 1, current * 10 + next, results);
    }
}
