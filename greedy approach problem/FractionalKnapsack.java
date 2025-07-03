import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        // Predefined number of items and knapsack capacity
        int n = 3;
        int capacity = 50;

        // Predefined array of items: {value, weight}
        double[][] items = {
            {60, 10},
            {100, 20},
            {120, 30}
        };

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));

        double maxValue = 0.0;
        int remainingCapacity = capacity;

        // Greedy selection of items
        for (int i = 0; i < n; i++) {
            double value = items[i][0];
            double weight = items[i][1];

            if (remainingCapacity >= weight) {
                maxValue += value;
                remainingCapacity -= weight;
            } else {
                maxValue += (value / weight) * remainingCapacity;
                break;
            }
        }

        // Output only the final value (2 decimal places)
        System.out.printf("%.2f\n", maxValue);
    }
}