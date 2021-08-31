package bytebybyte;

/**
 * Created by home on 2/23/2021.
 */
public class MatrixSquare {

    public static void main(String args[]){
        boolean arr[][] = new boolean[][] {
                                            {false, false, false },
                                            {false, true, false},
                                            {false, false, true},
        };

        MatrixSquare ms = new MatrixSquare();
        //ms.zeroMatrix(arr);
        boolean[][] copy = new boolean[arr.length][arr[0].length];

        //ms.print(arr, true, copy);
        //ms.rowColMat(arr, copy);
        ms.print(arr, false, copy);
    }

    public void print(boolean[][] arr, boolean c, boolean[][] copy) {

        System.out.println(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" " + arr[i][j]);
                if(c){
                   copy[i][j] = arr[i][j];
                }
            }
            System.out.println(" ");
        }
    }

    public void rowColMat(boolean[][] matrix, boolean[][] copy) {

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    matrix[i][0] = true;
                    matrix[0][j] = true;
                }
            }
        }
    }

    // Brute force solution. From each cell find the biggest square submatrix for which it is the upper left-hand corner
    public int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        int cache[][] = new int[arr.length][arr[0].length];
        // Compute for each cell the biggest subarray
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (i == 0 || j == 0) {
                    cache[i][j] = arr[i][j] ? 1 : 0;
                } else if (arr[i][j]) {
                    cache[i][j] =
                            Math.min(Math.min(cache[i][j-1],
                                    cache[i-1][j]),
                                    cache[i-1][j-1]) + 1;
                }
                if (cache[i][j] > max)
                    max = cache[i][j];
            }
        }
        return max;
    }

    public int squareSubmatrix1(boolean[][] arr) {
        // Initialize cache. Don't need to initialize
        // to -1 because the only cells that will be
        // 0 are ones that are false and we want to
        // skip those ones anyway
        int[][] cache = new int[arr.length][arr[0].length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j])
                    max = Math.max(max, squareSubmatrix(arr, i, j, cache));
            }
        }
        return max;
    }


    // Overloaded recursive function
    private int squareSubmatrix(boolean[][] arr, int i, int j, int[][] cache) {

        // Base case at bottom or right of the matrix
        if (i == arr.length || j == arr[0].length)
            return 0;
        // If the cell is false then it’s not part of a valid submatrix
        if (!arr[i][j]) return 0;
        // Find the size of the right, bottom, and bottom right submatrices and add 1 to the minimum of those 3 to get the result
        if (cache[i][j] > 0) return cache[i][j];
        cache[i][j] = 1 + Math.min(Math.min(
                            squareSubmatrix(arr, i+1, j, cache),
                            squareSubmatrix(arr, i, j+1, cache)),
                            squareSubmatrix(arr, i+1, j+1, cache));

        return cache[i][j];
    }

}

