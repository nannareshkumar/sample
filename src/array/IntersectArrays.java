package array;

import java.util.*;

/**
 * Created by home on 12/15/2020.
 */
public class IntersectArrays {

    public static void main(String args[]){

        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] result = intersection( nums1, nums2 );

        for(int i = result.length-1; i >=0; i--){
            System.out.print(" " + result[i]);
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        int n1len = nums1.length;
        int n2len = nums2.length;

        int index1=0, index2=0, rindex=0;
        Set<Integer> result = new HashSet();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(index1 < n1len && index2 < n2len){

            if(nums1[index1] == nums2[index2]){
                result.add(nums1[index1]);
                index1++; index2++;
            } else if(nums1[index1] < nums2[index2]){
                index1++;
            } else {
                index2++;
            }
        }

        int[] res = new int[result.size()];
        Iterator iter = result.iterator();
        while(iter.hasNext()){
           res[rindex++] = (Integer) iter.next();
        }
        Arrays.sort(res);
        return res;
    }
}
