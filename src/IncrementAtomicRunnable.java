/**
 * Created by home on 10/2/2017.
 */
public class IncrementAtomicRunnable implements Runnable{
    protected LongOverhead oh;
    protected int loopTotal;
    protected int waitMilliseconds;
    protected String currentThreadName;

    public IncrementAtomicRunnable(LongOverhead oh, int loopTotal, int waitMilliseconds){
        this.oh = oh;
        this.loopTotal = loopTotal;
        this.waitMilliseconds = waitMilliseconds;
    }

    @Override
    public void run(){
        currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " for ATOMIC is starting.....");
        for(int x=0;x<loopTotal;x++){
            oh.incrAtomicLong();
            try{
                Thread.sleep(waitMilliseconds);
            }catch(InterruptedException e){
                System.out.println("InterruptedThread[" + currentThreadName + "], eating exception @@@@@");
            }
        }

        System.out.println("....." + currentThreadName + " for ATOMIC is finished.");
    }
}