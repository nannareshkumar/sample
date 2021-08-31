package threads;

/**
 * Created by home on 10/28/2017.
 */
public class DeadLock {
    public void printBinaryFormat(int number){
        int binary[] = new int[25];
        int index = 0;
        while(number > 0){
            binary[index++] = number%2;
            number = number/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }

    public static void main(String a[]){
        DeadLock dtb = new DeadLock();
        dtb.printBinaryFormat(250);
    }
 }


