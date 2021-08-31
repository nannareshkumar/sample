package threads;

/**
 * Created by home on 10/2/2017.
 */
public class IncrementPrimitiveRunnable extends IncrementAtomicRunnable{

    public IncrementPrimitiveRunnable(LongOverhead oh, int loopTotal, int waitMilliseconds){
        super(oh, loopTotal, waitMilliseconds);
    }

    @Override
    public void run(){
        super.currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " for PRIMITIVE is starting.....");
        for(int x=0;x<loopTotal;x++){
            oh.incrPrimitiveLong();
            try{
                Thread.sleep(waitMilliseconds);
            }catch(InterruptedException e){
                System.out.println("InterruptedThread[" + currentThreadName + "], eating exception @@@@@");
            }
        }

        System.out.println("....." + currentThreadName + " for PRIMITIVE is finished.");
    }
}