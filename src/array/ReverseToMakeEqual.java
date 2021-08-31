package array;

import java.util.Arrays;

/**
 * Created by home on 5/28/2020.
 *
 *
 * Reverse to Make Equal
 Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
 Signature
 bool areTheyEqual(int[] arr_a, int[] arr_b)
 Input
 All integers in array are in the range [0, 1,000,000,000].
 Output
 Return true if B can be made equal to A, return false otherwise.
 Example
 A = [1, 2, 3, 4]
 B = [1, 4, 3, 2]
 output = true
 After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 *
 *
 *
 */
public class ReverseToMakeEqual {

    public static void main(String args[]) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{1, 4, 3, 2};
        System.out.println(" check for subArray equal or not: " + checkForEqual(A, B));

    }


    public static boolean checkForEqual(int[] array_a, int B[] ) {

        boolean isEqual = false;

        if(array_a.length > 0  && B.length > 0) {

            for(int k=0;k<B.length-1;k++) {
                int[] copyA = Arrays.copyOfRange(array_a, k, array_a.length);
                int[] copyB = Arrays.copyOfRange(B, k, B.length);

                int[] copyRevB = new int[copyB.length];
                for (int i = copyB.length-1, j=0; i >= 0; i--, j++) {
                    copyRevB[j] = copyB[i];
                }

                isEqual = Arrays.equals(copyA, copyRevB);
                if(isEqual)
                    break;
            }

        }

        return isEqual;
    }


}
