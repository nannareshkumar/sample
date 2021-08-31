package array;

/**
 * Given an array of integers A of size N and an integer B.

 array A is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

 You are given a target value B to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 NOTE:- Array A was sorted in non-decreasing order before rotation.

 NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 Input Format

 The first argument given is the integer array A.
 The second argument given is the integer B.
 Output Format

 Return index of B in array A, otherwise return -1
 Constraints

 1 <= N <= 1000000
 1 <= A[i] <= 10^9
 all elements in A are disitinct.
 For Example

 Input 1:
 A = [4, 5, 6, 7, 0, 1, 2, 3]
 B = 4
 Output 1:
 0
 Explanation 1:
 Target 4 is found at index 0 in A.


 Input 2:
 A = [5, 17, 100, 3]
 B = 6
 Output 2:
 -1
 */
public class RotateArray {

    public static void main(String args[]){
        int[] A = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        int B = 4, result;
        RotateArray ra = new RotateArray();

        System.out.println("Value of the index: " + ra.pivotBinarySearch(A, B));
    }

    public int pivotBinarySearch(int[] A, int B){
        int pivot = findPivote(A, 0, A.length);
        if(pivot ==-1)
            return binarySearch(A, B, 0, A.length-1);

        if (A[pivot] == B)
            return pivot;
        if (A[0] <= B)
            return binarySearch(A, B,0, pivot - 1);

        return binarySearch(A, B, pivot + 1, A.length);
    }


    public int binarySearch(int[] A, int B, int start, int end){
        if (end < start)
            return -1;

        /* low + (high - low)/2; */
        int mid = (start + end) / 2;
        if (B == A[mid])
            return mid;
        if (B > A[mid])
            return binarySearch(A, B, (mid + 1), end);
        return binarySearch(A, B, start, (mid - 1));
    }



    public int findPivote(int[] A, int start, int end){

        if(end < start)
            return -1;

        if(end == start)
            return start;

        int mid = (start + end)/2;
        if(mid < end && A[mid] > A[mid+1]){
            return mid;
        }
        if (mid > start && A[mid] < A[mid - 1]) {
            return mid - 1;
        }
        if (A[start] >= A[mid]) {
            return findPivote(A, start, mid - 1);
        }
        return findPivote(A, mid+1, end);
    }



}
