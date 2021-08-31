package array;

import java.util.*;

/**
 * Created by home on 2/9/2021.
 */
public class ThreeSum {

    public static void main(String args[]){

        int nums[] = new int[]{ -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
        int B = -1;
        ThreeSum ts = new ThreeSum();
        System.out.println( "  result: " + ts.threeSumClosest(nums, B));

//        Iterator iter = res.iterator();
//        while(iter.hasNext()){
//         List<Integer> list = (List<Integer>) iter.next();
//         for(int i =0; i<list.size(); i++)
//            System.out.print(" " + list.get(i));
//
//         System.out.println(" ");
//        }

    }

    public int threeSumClosest(int[] nums, int B) {

        int res = -1;
        if(nums.length < 3)
            return res;

        Set<Integer> all = new HashSet();
        for(int i=0; i<nums.length; i++) {

            if(all.contains(nums[i])){

            }

           all.add(nums[i]);
        }

        for(int i=0; i < nums.length-1; i++){
            int sum = nums[i];
            if(all.contains(0) && all.contains(-nums[i])){

            }

            if(sum > 0) {
                if(all.contains(-sum) && (Math.abs(-sum + B)==1 ) )
                    res = -sum;
            }
            else{
                if(all.contains(sum) && (Math.abs(sum+B) ==1) )
                    res = sum;
            }
        }
        return res;
    }



    public List<List<Integer>> threeSumContains(int[] nums) {

            List<List<Integer>> res = new ArrayList();
            if(nums.length < 3)
                return res;

            Set<Integer> all = new HashSet();
            for(int i=0; i<nums.length; i++)
                all.add(nums[i]);

            for(int i=0; i < nums.length-1; i++){
                int sum = nums[i] + nums[i+1];
                boolean check = false;
                if(sum > 0)
                    check = all.contains(-sum);
                else
                    check = all.contains(sum);

                if(check){
                    List<Integer> pair = new ArrayList();
                    pair.add(nums[i]);
                    pair.add(nums[i+1]);
                    pair.add(-sum);
                    Collections.sort(pair);

                    if(!res.contains(pair))
                        res.add(pair);
                }
            }
            return res;
        }
    }