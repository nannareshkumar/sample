package threads;

/**
 * Created by home on 3/4/2020.
 */
public class Sample {

    public static void main (String arg[]) {
       Sample s = new Sample();
       MathTest mt = new MathTest();
       performTest pt;

       pt = mt.checkEven();
       mt.check1(pt, 10);


    }


}

interface performTest {
    int check(int a);
}

class MathTest {
    public int check1(performTest p, int num) {
        return p.check(num);
    }

    performTest checkEven() {
        return a -> a % 2;
    }
}