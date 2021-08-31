package probs;

import java.util.Arrays;

/**
 * Created by home on 1/11/2021.
 */
public class SortColors {

    public static void main(String args[]) {
        int[] nums = new int[]{2,0,2,1,1,0};

        SortColors s = new SortColors();
        s.sortColors(nums);

        for(int i =0; i< nums.length; i++)
            System.out.print(" " + nums[i]);


    }

    public void sortColors(int[] nums) {

        int[] items = new int[3];

        for (int i = 0; i < nums.length; i++) {
            items[nums[i]] = items[nums[i]] + 1;
        }

        int k = 0;
        for (int i = 0; i < items.length; i++) {
            populate(nums, k, k+items[i], i);
            k +=items[i];
        }
    }

    public static void populate(int[] nums, int start, int end, int val) {

        for (int i = start; i < end; i++) {
            nums[i] = val;
        }
    }
}