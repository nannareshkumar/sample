package probs;

import java.util.*;

/**
 * Created by home on 5/28/2020.
 */
public class PassYearBook {

    public static void main(String[] args) {
        int[] nums1 = {2, 1};
        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(solve(nums1)));
        System.out.println(Arrays.toString(solve(nums2)));
    }

    private static int[] solve(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i+1);
        }
        Set<Integer> visited = new HashSet<>();
        for(int k : map.keySet()) {
            if(!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while(!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = map.get(k);
                }
                for(int i : round) {
                    res[i-1] = round.size();
                }
            }
        }
        return res;
    }


}
