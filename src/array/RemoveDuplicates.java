package array;

/**
 * Created by home on 5/13/2020.
 */
public class RemoveDuplicates {

    public static void main(String args[]) {

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(nums);


        System.out.println("length: " + length );
        System.out.println("Array: "  );

        for(int j=0; j < length; j++) {
           System.out.println(nums[j]);
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
