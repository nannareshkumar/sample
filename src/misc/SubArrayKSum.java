package misc;

import java.util.*;

public class SubArrayKSum {

    public static void main(String args[]){
        int[] nums = new int[] {1,2,3};
        System.out.println("result of :" + subArraySum(nums, 3));
    }

    public static int subArraySum(int[] nums, int k) {

        Map<Integer, Integer> sums = new HashMap();
        sums.put(0, 1);
        int sum = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer value = sums.get(k-sum);
            if (value != null) {
                result += value;
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

}
