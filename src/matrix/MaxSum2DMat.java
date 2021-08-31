package matrix;

/**
 * Created by home on 12/24/2020.
 */
public class MaxSum2DMat {
        public int maxSum(int grid[][], int n)
        {
            int incl = Math.max(grid[0][0], grid[1][0]);
            int excl = 0, excl_new;

            for (int i = 1; i < n; i++ ) {
                excl_new = Math.max(excl, incl);
                incl = excl + Math.max(grid[0][i], grid[1][i]);
                excl = excl_new;
            }

            return Math.max(excl, incl);
        }

    public int maxSumDP(int grid[][], int n) {


        if(grid.length <=0)
            return 0;

        int dp[] = new int[n];

        for (int j=0; j < n; j++) {
            dp[j] =  Math.max(grid[0][j], grid[1][j]);
            if(j>=2){
                dp[j] = dp[j]+dp[j-2];
            }
        }
//        int res =0;
//        if (dp.length >=2){
//            res = Math.max(dp[n-1], dp[n-2]);
//        } else {
//            res = dp[0];
//        }

        return (dp.length >=2) ? Math.max(dp[n-1], dp[n-2]) : dp[0] ;
    }




        /* Driver program to test above function */
        public static void main(String[] args) {
            int grid[][] = {{ 1, 2, 3, 4, 5},
                            { 6, 7, 8, 9, 10}};
//            int grid[][] = {{1},{2}};

            int n = grid[0].length;
            MaxSum2DMat m = new MaxSum2DMat();
            System.out.println(m.maxSum(grid, n));
            System.out.println(m.maxSumDP(grid, n));
        }
   }
