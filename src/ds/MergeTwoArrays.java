package ds;

import java.util.Arrays;

/**
 * A = {1,3,5,0,0,0}
 B = {2,4,6}
 mergeArrays(A, B)
 A = {1,2,3,4,5,6}

 */
public class MergeTwoArrays {

    public static void main(String args[]){

        MergeTwoArrays m = new MergeTwoArrays();
        int[] A = new int[]{1,3,5,0,0,0};
        int[] B = new int[]{2,4,6};

        int aIndex = A.length-1;
        for(int i = A.length-1; i >= 0; i--){
            if(A[i] > 0) {
                aIndex = i;
                break;
            }
        }

        m.mer2(A, B, aIndex);
        for(int t =0; t<A.length; t++ ){
            System.out.print(" " + A[t]);
        }
    }

    /*
    * {1,3,5,0,0,0}
    * {2,4,6}
    * */
    public void mer2(int A[], int B[], int aIndex){

        int bIndex = B.length-1, mIndex=A.length-1;
        while(aIndex >=0 && bIndex >=0){
            if(A[aIndex] > B[bIndex]){
                A[mIndex] = A[aIndex];
                aIndex--;
            } else {
                A[mIndex] = B[bIndex];
                bIndex--;
            }
            mIndex--;
        }
    }


    public void mer(int[] A, int[] B){

        if(A.length > B.length) {

            int index = A.length - 1;
            for (int j = 0; j < B.length; j++) {
                if (A[index] == 0) {
                    A[index--] = B[j];
                }
            }
            Arrays.sort(A);
        }
    }




}
