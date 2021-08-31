package bytebybyte;

import java.util.*;
/**
 * Created by home on 3/4/2021.
 */
public class ZeroSumArray {

    public static void main(String args[]) {

        System.out.println(" result : " + zeroSum(new int[]{1, 1, 1}, 2));

    }

    public static int zeroSum(int[] nums, int k) {

        Map<Integer, Integer> sums = new HashMap();
        sums.put(0, 1);
        int sum = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer value = sums.get(sum - k);
            if (value != null) {
                result += value;
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
//        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
//        int sum = 0;
//        for (int i = 0; i <= arr.length; i++) {
//            Integer oldIndex = sums.get(sum);
//            if (oldIndex == null && i == arr.length) {
//                return null;
//            } else if (oldIndex == null) {
//                sums.put(sum, i);
//                sum += arr[i];
//            } else {
//                return Arrays.copyOfRange(arr, oldIndex, i);
//            }
//        }
//
//        return null;
//    }
