package interviewbit;

import java.util.*;

public class RotatedArray {

    public static void main(String args[]){
//        int[] A = new int[]{ 186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74, 77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148, 150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185 };
//        int B = 143;

       int[] A = new int[] {1, 7, 67, 133, 178}; //{ 5, 6, 7, 0, 1, 2, 3, 4}; //new int[] { 1, 7, 67, 133, 178 };
        int B = 1;
//        A : [ 192, 194, 197, 198, 199, 200, 201, 203, 204, 2, 3, 4, 7, 9, 10, 11, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 33, 34, 35, 36, 39, 40, 42, 43, 46, 47, 50, 51, 52, 53, 55, 57, 59, 60, 64, 66, 68, 70, 71, 72, 75, 76, 78, 85, 86, 87, 91, 92, 94, 95, 96, 99, 102, 105, 106, 107, 109, 111, 113, 114, 115, 119, 120, 121, 123, 125, 129, 130, 131, 133, 134, 137, 138, 139, 140, 141, 142, 143, 145, 146, 149, 151, 152, 156, 160, 161, 165, 167, 168, 170, 171, 176, 177, 178, 179, 180, 181, 182, 185, 186, 190 ]
//        B : 70

        RotatedArray ra = new RotatedArray();
        System.out.println( " Index of : " + ra.search(A, B) + " value " + B);

    }
    public int search(final int[] A, int B) {

        int pivot = findPivot(A, 0, A.length-1);
        System.out.println(" pivot index :" + pivot);

        int index=-1;
        if(pivot ==-1)
            index = binarySearch(A, 0, A.length-1, B);
        else {
            if(B < A[pivot] && B > A[0])
                index = binarySearch(A, 0, pivot, B);
            else
                index = binarySearch(A, pivot+1, A.length-1, B );
        }
        return index;
    }

    public int findPivot(int[] A, int low, int high){

        if(high < low)
            return -1;
        if(high == low)
            return low;

        int mid = (low + high)/2;

        if(mid < high && A[mid] > A[mid+1])
            return mid;
        if(mid > low && A[mid] < A[mid-1])
            return mid-1;

        if(A[low] > A[mid])
            return findPivot(A, low, mid);
        else
            return findPivot(A, mid+1, high);
    }

    public int binarySearch(int[] A, int low, int high, int B){

         if(high < low)
            return -1;

         int mid = (low + high)/2;
         if(B == A[mid])
           return mid;
         if(B < A[mid])
           return binarySearch(A, low, mid-1, B);
         else
           return binarySearch(A, mid+1, high, B);

    }


}
