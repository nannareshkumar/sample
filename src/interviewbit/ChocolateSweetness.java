package interviewbit;

public class ChocolateSweetness {

    public static void main(String[] args) {
        ChocolateSweetness cs = new ChocolateSweetness();
        int[] chocolates = {2,2,2,2}; //{1,2,3,4,5}; // {6, 3, 2, 8, 7, 5};
        int k = 3;
        int res = cs.maxSweetness(chocolates, k);
        System.out.println(res);
    }

    public int maxSweetness(int[] arr, int k) {
        int n = arr.length;
        // dp[i][j]: The max sweetness when splitting the first j chunks of chocolates to i children.
        int[][] dp = new int[k+1][n+1];
        dp[1][1] = arr[0];
        int[] preSums = new int[n];
        preSums[0] = arr[0];
        for(int j=2; j<=n; j++) {
            // When there is only 1 child, he gets all chocolate chunks.
            dp[1][j] = dp[1][j-1] + arr[j-1];
            preSums[j-1] = preSums[j-2] + arr[j-1];
        }
        for(int i=2; i<=k; i++) {
            for(int j=i; j<=n; j++) {
                int max = 0;
                for(int h=i-1; h<j; h++) {
                    // Try to split the first i-1 to j-1 chunks to i-1 children,
                    // and find the max value.
                    max = Math.max(max, Math.max(dp[i-1][h], preSums[j-1] + preSums[h-1]));
                }
                dp[i][j] = max;
            }
        }

        return dp[k][n];
    }


}
