package bytebybyte;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by home on 2/21/2021.
 */
public class MakeChange {

    public static void main(String args[]){
        int[] coins = new int[]{10, 6, 1};
        MakeChange mc = new MakeChange();

        int result = mc.makeChange(25, coins);
        System.out.println(String.format(" minumum number of coins to make : %s", result));
    }

    //top-down approach
//    public int makeChange(int c, int[] coins) {
//        if (c == 0) return 0;
//        int minCoins = Integer.MAX_VALUE;
//        // Try removing each coin from the total and
//        // see how many more coins are required
//        for (int coin : coins) {
//            // Skip a coin if it’s value is greater
//            // than the amount remaining
//            if (c - coin >= 0) {
//                int currMinCoins = makeChange(c - coin, coins);
//                if (currMinCoins < minCoins)
//                    minCoins = currMinCoins;
//            }
//        }
//        // Add back the coin removed recursively
//        return minCoins + 1;
//    }

    //bottom up approach
    public int makeChange(int c, int[] coins) {
        int[] cache = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            int minCoins = Integer.MAX_VALUE;

            // Try removing each coin from the total
            // and see which requires the fewest
            // extra coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    int currCoins = cache[i-coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[c];
    }

//    public int makeChange(int c, int[] coins) {
//        // Initialize cache with values as -1
//        int[] cache = new int[c + 1];
//        for (int i = 1; i < c + 1; i++)
//            cache[i] = -1;
//        return makeChange(c, cache, coins);
//    }
//    // Overloaded recursive function
//    private int makeChange(int c, int[] cache, int[] coins) {
//        // Return the value if it’s in the cache
//        if (cache[c] >= 0) return cache[c];
//
//        int minCoins = Integer.MAX_VALUE;
//
//        // Find the best coin
//        for (int coin : coins) {
//            if (c - coin >= 0) {
//                int currMinCoins =
//                        makeChange(c - coin, cache);
//                if (currMinCoins < minCoins)
//                    minCoins = currMinCoins;
//            }
//        }
//
//        // Save the value into the cache
//        cache[c] = minCoins + 1;
//        return cache[c];
//    }

    public int makeChangeOwn(int t, int[] coins){

        Arrays.sort(coins);
        List<Integer> res = new ArrayList();

        int sum = 0;
        for(int i =0; i< coins.length; i++){
            sum = sum + coins[i];
            res.add(coins[i]);
            for(int j =0; j<coins.length; j++){
               if(sum < t){
                   if(sum + coins[j] <= t) {
                       sum = sum + coins[j];
                       res.add(coins[j]);
                   }
               }

            }
        }
           return res.size();
    }


}
