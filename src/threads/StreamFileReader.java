package threads; /**
 * Created by home on 9/17/2017.
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamFileReader {

  
        /**
         * @author Crunchify.com
         * @throws Exception
         *
         */

        public static void main(String[] args) throws Exception {
            StreamFileReader memoryTest = new StreamFileReader();
            memoryTest.generateOOM();
        }

        public void generateOOM() throws Exception {
            int iteratorValue = 20;
            System.out.println("\n=================> OOM test started..\n");
            for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
                System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
                int loop1 = 2;
                int[] memoryFillIntVar = new int[iteratorValue];
                // feel memoryFillIntVar array in loop..s
                do {
                    memoryFillIntVar[loop1] = 0;
                    loop1--;
                    System.out.println("\n loop: " + loop1);
                } while (loop1 > 0);
                iteratorValue = iteratorValue * 5;
                System.out.println("\nRequired Memory for next loop: " + iteratorValue);
                Thread.sleep(1000);
            }
        }

}