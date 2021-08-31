package minmax;

/**
 * Created by home on 12/23/2020.
 */
public class MinCostMatrix {

    public static void main(String atgs[]){

        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        MinCostMatrix mnc= new MinCostMatrix();


        System.out.println(mnc.minCostMartrix(cost));
    }

    public int minCostMartrix(int[][] cost){

        int rows = cost.length;
        int cols = cost[0].length;

        int[][] res = new int[rows][cols];
        for(int i =0; i < rows; i++ ) {
                res[i][0]= cost[i][0];
        }
        for(int i =0; i < cols; i++ ) {
            res[0][cols]= cost[0][cols];
        }


        for(int i =0; i < rows; i++ ){
           for(int j=0; j < cols; j++) {

               if(i==0 && j>0)
                res[i][j] = res[i][j-1] + cost[i][j];
               else if(j ==0 && i > 0)
                res[i][j] = res[i-1][j] + cost[i][j];
               else if(i > 0 && j > 0)
                    res[i][j] = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1])) + cost[i][j];
           }
        }
        return res[rows-1][cols-1];
    }
}
