package matrix;

/**
 * Created by home on 1/4/2021.
 */
public class MatrixSearch {

    public static void main(String args[]){
        int[][] m = new int[][]{{1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}};
        int ele = 11;
        System.out.println("Given element does exists:" + matrixSearch(m, ele));


    }

    public static boolean matrixSearch(int[][] m, int ele){

        int rIndex=0, cIndex=m[0].length-1;

        for(int i =0; i<m.length; i++){
           if( m[i][cIndex] > ele) {
               rIndex = i;
               break;
           }
        }
        boolean isExists = false;
        for(int i=0; i<m[0].length; i++){
            isExists =(m[rIndex][i] == ele);
            if(isExists == true)
                break;
        }

        return isExists;

    }

    public boolean contains(int[][] arr, int x) {
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



}
