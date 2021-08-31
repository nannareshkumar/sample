package dp;

import java.util.Arrays;

/**
 * Created by home on 10/26/2020.
 */
public class DynamicProg {

    static int solveCoinChange(int[] denominations, int amount) {
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den: denominations) {
            for (int i = den; i < (amount + 1); ++i) {
                solution[i] += solution[i - den];
            }
        }
        return solution[solution.length - 1];
    }
    public static void main(String[] args) {

        int[] denominations = new int[] {1, 3, 5};
        int amount = 7;
        int result = solveCoinChange(denominations, amount);
        System.out.print("SolveCoinChange(" + Arrays.toString(denominations) +  ", " + amount + ") = ");
        System.out.print(result);
    }
}
