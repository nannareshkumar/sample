package interviewbit;

import java.util.Arrays;

/**
 * Created by home on 3/1/2021.
 */
public class Sum3 {

    public static void main(String args[]){

        Sum3 s = new Sum3();
        int[] S = new int[]{-1, 2, 1, -4};
        int target = 1;
        int[] res = s.getSum3(S, target);

        for(int i=0; i<res.length; i++){
            System.out.print(" " + res[i]);
        }

    }

    public int[] getSum3(int[] s, int t){

        int[] result = new int[3];

        Arrays.sort(s);

        int start, end, sum, min = Integer.MAX_VALUE;
        for(int i =0; i< s.length-3; i++){
            start = i+1;
            end = s.length-1;

            while(start<end) {
                sum = s[i] + s[start] + s[end];
                if(Math.abs(sum - t) < min) {
                    min = Math.abs(sum - t);
                    result = new int[]{s[i], s[start], s[end]};
                }

                if (sum == t) {
                    result = new int[]{s[i], s[start], s[end]};
                } else if (sum < t) {
                    start = start + 1;
                } else if (sum > t) {
                    end = end - 1;
                }
            }
        }
        return result;

    }

}
