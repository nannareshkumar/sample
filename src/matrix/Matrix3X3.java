package matrix;

/**
 * Created by home on 10/27/2020.
 */
public class Matrix3X3 {

    public static void main(String srgs[]){

        prepare(3);
    }

    public static void prepare(int n1){

        int n = 5;
        int[][] matr = new int[n][n];

        int val = n1;
        for(int i=0; i<n; i++ ){
            for(int j=0; j<n; j++ ){
                matr[i][j] = val;
                System.out.print( " " + matr[i][j] );
                if( i == j ){
                    val = n1 - 1;
                } else{
                    val = n1;
                }
            } //j
            System.out.println("");
            val = n1;
        } //i
    }


}
