package dp;

import java.util.Arrays;

public class MinPath {

    public static void main(String args[]){
        int[][] mat = new int[][] {

                                     };





    }

    public void print(int[][] mat) {
        for(int i=0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println("");
        }
    }


    public int[][] minPath(int[][] mat){

        int rows = mat.length;
        int[][] result = new int[rows][];
        Arrays.fill(result, -1);

        for(int i=0; i < rows; i++){
            for(int j=0; j < mat[i].length; j++){
               result[i][j] = result[i][j] + Math.min(mat[i][j+1], mat[i+1][j]);
            }
        }

        return result;
    }



}
