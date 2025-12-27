import java.util.*;

class fracKnapsack {

    // Method
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        double[][] ratio = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / wt[i];
        }

        Arrays.sort(
            ratio,
            Comparator.comparingDouble((double[] o) -> o[1]).reversed()
        );

        int C = capacity;
        double final_val = 0.0;

        for (int i = 0; i < ratio.length && C > 0; i++) {
            int idx = (int) ratio[i][0];

            if (C >= wt[idx]) {
                final_val += val[idx];
                C -= wt[idx];
            } else {
                final_val += ratio[i][1] * C;
                break;
            }
        }

        return final_val;
    }

    // main method
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        double result = fractionalKnapsack(val, wt, capacity);
        System.out.println(result);  // Output: 240.0
    }
}
