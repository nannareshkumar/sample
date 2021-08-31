package bytebybyte;

/**
 * Created by home on 3/2/2021.
 */
public class MedianArrays {

    public static void main(String args[]) {
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3,4};

        MedianArrays ma = new MedianArrays();
        System.out.println("resutl : " + ma.findMedianSortedArrays(arr1, arr2));

    }

    public double findMedianSortedArrays(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];
        int aIndex = 0, bIndex = 0;

        for (int resIndex = 0; resIndex < res.length; resIndex++) {

            if (aIndex < a.length && bIndex < b.length) {
                if (a[aIndex] < b[bIndex]) {
                    res[resIndex] = a[aIndex];
                    aIndex++;
                } else {
                    res[resIndex] = b[bIndex];
                    bIndex++;
                }
            } else  if (aIndex < a.length) {
                res[resIndex] = a[aIndex++];
            } else  if (bIndex < b.length) {
                res[resIndex] = b[bIndex++];
            }
        }

        double median = 0;
        int len = res.length, mid=(res.length/2);
        if (len % 2 == 0) {
            median = (res[mid-1] + res[mid])/2.0;
        } else {
            median = res[mid];
        }

        return median;
    }
}