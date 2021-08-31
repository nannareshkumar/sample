package interviewbit;

/**
 * Created by home on 2/28/2021.
 */
public class Meetings {

    public static void main(String args[]){
      int[][] A = new int[][]{
              {1, 18},
              {18, 23},
              {15, 29},
              {4, 15},
              {2, 11},
              {5, 13}
      };

      Meetings m = new Meetings();
      System.out.println("result : " + m.solve(A) );


    }

    public void print(int[][] B){

        for(int i =0;i<B.length; i++){
            for(int j=0; j<B[i].length; j++){
                System.out.print(" " + B[i][j]);
            }
            System.out.println("");
        }

    }


    public int solve(int[][] A) {

        int maxLength = Integer.MIN_VALUE;
        int[][] B = new int[A.length][30];
        for(int i =0; i < A.length; i++){
            for(int j = A[i][0]; j < A[i][1]; j++){
                B[i][j]=1;
                if(maxLength<j)
                    maxLength = j;
            }
        }

        print(B);

        int max=0;
        int[] result = new int[maxLength];
        for(int k=0; k < maxLength; k++){

            int col =0;
            for(int i =0; i < B.length; i++){
                if(B[i][k] == 1)
                    col = col+1;
            }
            result[k] = col;
            if(max < result[k])
                max = result[k];
        }

        System.out.println("");
        for(int i =0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }

        return max;
    }

}
