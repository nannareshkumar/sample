package probs;

/**
 * Created by home on 12/13/2020.
 */
public class RodCutting {

    // // A Naive recursive solution for Rod cutting problem
        /* Returns the best obtainable price for a rod of length
        n and price[] as prices of different pieces */
        static int cutRod(int price[], int n)
        {
            if (n <= 0)
                return 0;
            int max_val = Integer.MIN_VALUE;

            // Recursively cut the rod in different pieces and
            // compare different configurations
            for (int i = 0; i<n; i++) {
                max_val = Math.max(max_val, price[i] + cutRod(price, n - i - 1));

            }
            System.out.println(" size :" + n + " value:"+ max_val);

            return max_val;
        }

    static int cutRodFor(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_val = Math.max(max_val, price[j] + val[i - j - 1]);
                System.out.println("j:" + j + " max_value :" + max_val);
            }
            val[i] = max_val;
            System.out.println("val[" + i + "]:" + val[i] + " max_value:"+ max_val);
        }

        return val[n];
    }


    /* Driver program to test above functions */
        public static void main(String args[]) {
            int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
            int size = arr.length;
            System.out.println("Maximum Obtainable Value is "+ cutRodFor(arr, size));
            System.out.println("+++++++++++++++++++++++");
            //System.out.println("Maximum Obtainable Value is "+ cutRod(arr, size));

        }
    }
/* This code is contributed by Rajat Mishra */
