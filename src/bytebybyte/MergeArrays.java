package bytebybyte;

/**
 * Created by home on 1/30/2021.
 */
public class MergeArrays {

    public static void main(String args[]){
        int[] A = {1,3,5,0,0,0};
        int[]  B = {2,4,6};

        MergeArrays m = new MergeArrays();
        m.mergeArrays(A, B, 3, B.length);
        m.print(A);

    }

    public void mergeArrays(int[] a, int[] b, int aLength, int bLength) {

        if (aLength + bLength > a.length) throw new IllegalArgumentException();

        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        int mergeIndex = aLength + bLength - 1;

        while (aIndex >= 0 && bIndex >= 0) {
            if (a[aIndex] > b[bIndex]) {
                a[mergeIndex] = a[aIndex];
                aIndex--;
            } else {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }

            mergeIndex--;
        }

        while (bIndex >= 0) {
            a[mergeIndex] = b[bIndex];
            bIndex--;
            mergeIndex--;
        }
    }

    public void print(int[] a){
        for(int i=0; i<a.length; i++)
            System.out.print(" " +a[i]);

    }

}