package threads;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

/**
 * Created by home on 10/2/2017.
 */
public class LongOverhead {


    AtomicLong atomicLong;
    long primitiveLong;

    public LongOverhead() {
        atomicLong = new AtomicLong(0l);
        primitiveLong = 0l;
    }

    public void incrAtomicLong() {
        atomicLong.getAndAdd(1l);
    }

    public long getAtomicLong() {
        return atomicLong.get();
    }

    public void incrPrimitiveLong() {
        primitiveLong++;
    }

    public long getPrimitiveLong() {
        return primitiveLong;
    }

    public static void main(String[] args) {
        String template = "%s Results:  Elapsed = %d ms, ExpectedValue = %d, FinalValue = %d, %b";

        int loopTotal = 1000;
        int waitMilliseconds = 25;
        int totalThreads = 50;
        int expectedValue = loopTotal * totalThreads;
        int whileSleep = 250;

        LongOverhead atomic = new LongOverhead();
        LongOverhead primitive = new LongOverhead();

        List<Thread> atomicThreads = new ArrayList<>();
        List<Thread> primitiveThreads = new ArrayList<>();

        for (int x = 0; x < totalThreads; x++) {
            Thread a = new Thread(new IncrementAtomicRunnable(atomic, loopTotal, waitMilliseconds), "AtomicIncr" + x);
            atomicThreads.add(a);

            Thread p = new Thread(new IncrementPrimitiveRunnable(primitive, loopTotal, waitMilliseconds), "PrimitiveIncr" + x);
            primitiveThreads.add(p);
        }

        boolean cont = true;
        long atomicStart = System.currentTimeMillis();
        for (Thread t : atomicThreads) {
            t.start();
        }

        while (cont) {
            try {
                Thread.sleep(whileSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean foundAlive = false;
            for (Thread t : atomicThreads) {
                foundAlive = (Thread.State.TERMINATED != t.getState());
                if (foundAlive) {
                    break;
                }
            }

            cont = foundAlive;

        }

        long atomicFinish = System.currentTimeMillis();
        long atomicElapsed = atomicFinish - atomicStart;
        long atomicFinal = atomic.getAtomicLong();

        cont = true;
        long primitiveStart = System.currentTimeMillis();
        for (Thread t : primitiveThreads) {
            t.start();
        }

        while (cont) {
            try {
                Thread.sleep(whileSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean foundAlive = false;
            for (Thread t : primitiveThreads) {
                foundAlive = (Thread.State.TERMINATED != t.getState());
                if (foundAlive) {
                    break;
                }
            }

            cont = foundAlive;
            long primitiveFinish = System.currentTimeMillis();
            long primitiveElapsed = primitiveFinish - primitiveStart;
            long primitiveFinal = primitive.getPrimitiveLong();

            System.out.println(String.format(template, "ATOMIC", atomicElapsed, expectedValue, atomicFinal, (expectedValue == atomicFinal)));
            System.out.println(String.format(template, "PrImItIvE", primitiveElapsed, expectedValue, primitiveFinal, (expectedValue == primitiveFinal)));
        }
    }
}