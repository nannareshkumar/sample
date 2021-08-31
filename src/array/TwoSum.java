package array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 * Created by home on 5/3/2020.
 */
public class TwoSum {

       public static void main(String ars[]) {
           TwoSum var  = new TwoSum();
           int[] nums = new int[]{2,7,11,15};
           int[] result = var.twoSum(nums, 9);
           System.out.println ("final rsult: " + result[0] + " " + result[1]);
       }


        public int[] twoSum(int[] nums, int target) {

            int[] result = new int[2];
            for(int i = 0; i < nums.length; i++) {
                for(int j=0; j < nums.length; j++) {
                    if(i!=j && (target == (nums[i] + nums[j]))){
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
            return result;
        }

    public int[] twoSum3(int[] nums, int target) {

        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j=0; j < nums.length; j++) {
                if(i!=j && (target == (nums[i] + nums[j]))){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }



    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    }

    