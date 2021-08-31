package stringman;// Java implementation of the approach
import java.util.*;

public class Lectures {


    public static void main(String args[]){

        int lectures[][] = {{ 0, 1 }, { 0, 2 }, { 2, 3 },{ 1, 3 },{ 2, 4 },{ 3, 5 }};
        List<int[]> list = Arrays.asList(lectures);
        System.out.println("lectures : " + maxRoonV2(list));
    }

    public static int maxRoonV2(List<int[]> timeList){

        int[] HOURS = new int[24];
        for(int[] curr : timeList){
            for(int i = curr[0]; i < curr[1]; i++){
                ++HOURS[i];
            }
        }
        int max = 0;
        for(int i = 0; i < HOURS.length; i++){
            max = (max > HOURS[i]) ? max : HOURS[i];
        }
        return max;
    }

}

// This code is contributed by PrinciRaj1992
