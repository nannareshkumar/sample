package misc;

import java.util.*;
/**
 * Created by home on 3/8/2021.
 */
public class TwoSum {

    public static void main(String args[]){
        int[] nums = new int[]{3,3};//{2,7,11,15};
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(nums, 6);

        System.out.println("result :" + res[0] + " "+res[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();
        for(int i =0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        int j=0;
        for(int i =0; i<nums.length && j <2; i++){
            Integer res = map.get(target - nums[i]);
            if(res != null && res != i)  {
                result[j++] = i;
            }
        }

        return result;
    }



}
