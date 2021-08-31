package interviewbit;

import java.util.Arrays;

public class OptimalConstruct {

    public static void main(String args[]) {
      int[] A = new int[]{48,19,38,12,15,43,49,27,40,32,22}; //{8,28,40,9,19,49,33,32,22,7,4,36}; B=12
      Arrays.sort(A);
      System.out.println(" result :" + solve(A, 4));
    }

    public static int solve(int[] A, int B) {

        int result=0;
        if(B >= A.length)
            B = A.length-1;
        for(int i =0; i < A.length; i++){
            if(i <= B){

                result = result + Math.abs(A[B] - A[i]);
                if(i == B){
                    B=B+B;
                    if(B >= A.length)
                        B=A.length - 1;
                }
            }
        }
        return result;
    }

    }