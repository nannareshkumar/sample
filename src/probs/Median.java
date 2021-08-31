package probs;

import java.util.Arrays;

/**
 * Created by home on 5/12/2020.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 *
 *
 */
public class Median {

//    public static void main(String args[]) {
//        //merge the two arrays and find the median from them
//
//        int[] nums1 = new int[]{1,3};
//        int[] nums2 = new int[]{2};
//
//        Median m = new Median();
//
//        System.out.println(" result : " + m.findMedianSortedArrays(nums1, nums2) );
//
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        //merge two sorted two arrays
        // if the resulted length is even then use  ( n/2 + (n/2+1) )/2
        //if length is odd Math.abs(n/2)+1 )

        int[] res = sortElements(nums1, nums2);
        double result =0.0;
        if(res.length % 2 == 0 ){
           result = res[res.length/2];
        } else{
           result = (res[res.length/2] + res[res.length/2 + 1])/2;
        }
       return result;
    }

    public int[] sortElements(int[] nums1, int[] nums2 ){
         int[] res = new int[nums1.length + nums2.length];

         for(int i=0; i<nums1.length; i++)
             res[i]=nums1[i];

        for(int i=0; i<nums2.length; i++)
            res[nums1.length + i]=nums1[i];

        Arrays.sort(res);
        return res;
    }


        // Function to calculate median
        static int getMedian(int ar1[], int ar2[],
                             int n, int m)
        {

            // Current index of input array ar1[]
            int i = 0;

            // Current index of input array ar2[]
            int j = 0;
            int count;
            int m1 = -1, m2 = -1;

            // Since there are (n+m) elements,
            // There are following two cases
            // if n+m is odd then the middle
            //index is median i.e. (m+n)/2
            if ((m + n) % 2 == 1)
            {
                for(count = 0;    count <= (n + m) / 2;        count++)  {
                    if (i != n && j != m)  {
                        m1 = (ar1[i] > ar2[j]) ?
                                ar2[j++] : ar1[i++];
                    } else if (i < n) {
                        m1 = ar1[i++];
                    }
                    else {
                        m1 = ar2[j++];
                    }
                }
                return m1;
            }

            // median will be average of elements
            // at index ((m+n)/2 - 1) and (m+n)/2
            // in the array obtained after merging
            // ar1 and ar2
            else
            {
                for(count = 0;count <= (n + m) / 2; count++) {
                    m2 = m1;
                    if (i != n && j != m) {
                        m1 = (ar1[i] > ar2[j]) ?
                                ar2[j++] : ar1[i++];
                    } else if (i < n) {
                        m1 = ar1[i++];
                    } else  {
                        m1 = ar2[j++];
                    }
                }
                return (m1 + m2) / 2;
            }
        }

        // Driver code
        public static void main(String[] args)
        {
            int ar1[] = { 21, 900 };
            int ar2[] = { 5, 8, 10, 20 };

            int n1 = ar1.length;
            int n2 = ar2.length;

            System.out.println(getMedian(ar1, ar2, n1, n2));
        }
    }

// This code is contributed by Yash Singhal




