package threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by home on 10/29/2017.
 */
public class MissingNumber {
    static Logger logger = Logger.getLogger("threads.MissingNumber");

    public static void main(String ar[]) {
        int[] numbers = new int[]{1,2,3,4,6,7,8,9,10};

        try {
            int results = getMissingNumber(numbers);
            logger.log(Level.INFO, "Missing number is : " + results);
            int[] others = Arrays.copyOf(numbers, 1);
            int results1 = getMissingNumber(others);
            logger.log(Level.INFO, "Missing number is : " + results1);


        }catch (Exception e ) {
          logger.log(Level.SEVERE, "Exception in the code" + e.toString() );
        }

    }


    public static int getMissingNumber(int[]  n) throws Exception {
        if(n == null || n.length < 0) {
            throw new Exception("Array is not initialized or empty");
        }

        int expected = ((n.length+1) * (n.length+2))/2;
        logger.log(Level.INFO, "expected value:" + expected);

        int computed  = 0;

        for(int i: n) {
            computed += i;
        }

//        List<Integer> list = Arrays.asList(n);
//         computed  = list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();

        logger.log(Level.INFO, "computed:" + computed);
        return expected - computed;
    }

}
