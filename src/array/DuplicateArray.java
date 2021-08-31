package array;

import java.util.*;

/**
 * Created by home on 12/30/2020.
 */
public class DuplicateArray {

    public static void main(String args[]){

     int[] nums = new int[]{-2, -1, -2, 1};
     System.out.println("Duplicate elements are :" + findDuplicates2(nums) );



    }

    public static List<Integer> findDuplicates(int[] nums) {

        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i < nums.length; i++){
            Integer count = map.get(nums[i]);
            count  = (count != null) ? count++ : 1;
            map.put(nums[i], count);
        }
        List<Integer> list = new ArrayList(map.keySet());
        return list;
    }

   // byte by byte
    public static List<Integer> findDuplicates2(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;

            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        // Return the array to it's original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return new ArrayList(resultSet);
    }

}
