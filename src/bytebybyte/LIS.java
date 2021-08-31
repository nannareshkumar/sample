package bytebybyte;

import java.util.*;

public class LIS {

    public static void main(String args[]){

        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int max=0;

        Arrays.fill(lis, 1);

        for(int i=1; i < nums.length; i++ ){
            for(int j =0; j<=i; j++) {
                if(nums[i] > nums[j] && lis[i] < lis[j]+1)  {
                    lis[i] = lis[j]+1;
                    if(max < lis[i])
                        max= lis[i];
                }
            }
        }
        return max;

    }


}
