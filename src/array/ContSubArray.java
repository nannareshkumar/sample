package array;

/**
 * Created by home on 5/28/2020.
 *
 * Contiguous Subarrays
 You are given an array a of N integers. For each index i, you are required to determine the number of contiguous subarrays
 that fulfills the following conditions:
 The value at index i must be the maximum element in the contiguous subarrays, and
 These contiguous subarrays must either start from or end on index i.
 Signature
 int[] countSubarrays(int[] arr)
 Input
 Array a is a non-empty list of unique integers that range between 1 to 1,000,000,000
 Size N is between 1 and 1,000,000
 Output
 An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]
 Example:
 a = [3, 4, 1, 6, 2]
 output = [1, 3, 1, 5, 1]
 Explanation:
 For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 For index 1 - [4], [3, 4], [4, 1]
 For index 2 -[1]
 For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 For index 4 - [2]
 So, the answer for the above input is [1, 3, 1, 5, 1]
 *
 *
 *
 *
 */
public class ContSubArray {

    public static void main(String args[]){

        int[] a = new int[]{3, 4, 1, 6, 2};
        int[] res = countSubarrays(a);

        System.out.println("resultant values are: ");
        for(int i=0; i < res.length; i++){
          System.out.print(" " + res[i]);
        }
        System.out.println("\n\n");

        System.out.println("resultant values are: ");
        int[] test_2 = {2, 4, 7, 1, 5, 3};
        res = countSubarrays(test_2);
        for(int i=0; i < res.length; i++){
            System.out.print(" " + res[i]);
        }

    }

    public static int[] countSubarrays(int[] arr){

        int[] res = new int[arr.length];

        for(int i=0; i < arr.length; i++){
            int ele = arr[i];
            int count = 1;
            for(int j=i; j < arr.length; j++){
                if( i!=j && ele >= arr[j]){
                    count++;
                } else if(ele < arr[j]){
                    //count = 1;
                    break;
                }
            }

            for(int j=i; j >= 0; j--){
                if( i!=j && ele >= arr[j]){
                    count++;
                } else if(ele < arr[j]){
                    //count = 1;
                    break;
                }
            }


            res[i] = count;
        }

        return res;
    }



}
