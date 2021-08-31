package matrix;

/**
 * Created by home on 12/12/2020.
 */
public class MatrixPath {

    public static void main(String args[]){

        int[][] A = {{1,0}};
//       int[][] A = { { 0, 0, 0 },
//                     { 0, 1, 0 },
//                     { 0, 0, 0 } };

       System.out.println(" unique paths in given matrix : " + uniquePathsWithObstacles(A));
    }

    public static int uniquePathsWithObstacles(int[][] A) {

        int r = A.length;
        int c = A[0].length;
        int[][] path = new int[r][c];

        if(A[0][0]==0 )
            path[0][0]=1;

        if(A.length > 0) {
        for(int i=1; i < r; i++){
            if(A[i][0] == 0){
                path[i][0]=1;
            }
        }
        for(int i=1; i < c; i++){
            if(A[0][i] == 0){
                path[0][i]=1;
            }
        }
        for(int i=1; i < r; i++){
            for(int j=1; j < c; j++) {
                if (A[i][j] == 0) {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        }

    return path[r-1][c-1];
    }


}
