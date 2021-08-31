package bytebybyte;

import java.util.*;
/**
 * Created by home on 3/2/2021.
 */
public class CoinChangeWays {

    public static void main(String args[]){
        CoinChangeWays cw = new CoinChangeWays();
        System.out.println(" result : " +  cw.change(5, new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {

        Arrays.sort(coins);

        List<int[]> results = new ArrayList();
        for(int i=0; i < coins.length; i++){

            int j=i;

            int[] res = new int[amount];
            int x = amount - coins[i];
            if( x >= 0 && (x % coins[j] == 0)){
                res[i] = coins[i];
                int k=j;
                while( k < coins.length && (x%coins[j] ==0) ){
                    res[k+1] = coins[j];
                    k++;
                    x = x - coins[j];
                }
                res[k+1] = coins[j];
            }
            results.add(res);
        }

        return results.size();

    }

}
