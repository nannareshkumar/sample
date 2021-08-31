package bytebybyte;

/**
 * Created by home on 3/4/2021.
 */
public class MatrixSearch {

    public static void main(String args[]){
//       int[][] m = new int[][] { {1, 2, 3, 4},
//                                 {5, 6, 7, 8},
//                                 {9, 10, 11, 12}};
       int[][] m = new int[][] { {1,3,5,7}, {10,11,16,20}, {23,30,34,60} };
       System.out.println("element exist: " + searchMatrix(m, 3));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int r = matrix.length;
        if(r == 0) return false;

        int c = matrix[0].length;
        int r1 = 0, r2 = r-1, mid;
        while(r1 < r2){
            mid = r1 + (r2-r1)/2;
            if(matrix[mid][c-1] < target) r1 = mid+1;
            else if(matrix[mid][0] > target) r2 = mid-1;
            else{
                r1 = mid;
                break;
            }
        }

        int c1 = 0, c2 = c-1;
        while(c1 <= c2){
            mid = c1 + (c2-c1)/2;
            if(matrix[r1][mid] < target) c1 = mid+1;
            else if(matrix[r1][mid] > target) c2 = mid-1;
            else return true;
        }
        return false;
    }


    //byte by byte code which is giving wrong answer
// https://www.byte-by-byte.com/matrixsearch/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
    public static boolean contains(int[][] arr, int x) {
        if (arr.length == 0 || arr[0].length == 0) return false;
        int row = 0;
        int col = arr.length - 1;

        while (row < arr[0].length && col >= 0) {
            if (arr[row][col] == x) return true;
            if (arr[row][col] < x) row++;
            else col--;
        }

        return false;
    }

    public static boolean checkElement(int[][] m, int x) {
        boolean result = false;

        int end = m[0].length-1;
        for(int j=0; j< m.length; j++){
            if(m[j][end] >= x ){
                for(int i=0;i<m[0].length;i++){
                    if(m[j][i] == x){
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }



}
