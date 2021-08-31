package ds;

/**
 * Created by home on 5/8/2020.
 *
 * Problem statement is taken from the site https://www.interviewcake.com/question/python/merge-sorted-arrays
 *
 * my_list     = [3, 4, 6, 10, 11, 15]
 alices_list = [1, 5, 8, 12, 14, 19]

 # Prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
 print merge_lists(my_list, alices_list)
 *
 *
 *
 */
public class MergeTwoLists {

    public static void main(String args[]) {
        int[] my_list = new int[]{3, 4, 6, 10, 11, 15};
        int[] alices_list = new int[]{1, 5, 8, 12, 14, 19};

        int[] result = merge_lists(my_list, alices_list);
        printList(result);

    }

    static int[] merge_lists(int[] a, int[] b ){

        int[] result = new int[a.length + b.length];

        int index=0, prev = 0;
        for(int i=0; i < a.length; i++){
           for(int j=prev; j< b.length; j++) {
                if(b[j] < a[i]) {
                    result[index++] = b[j];
                    prev = j + 1;
                } else {
                    break;
                }
           }
            result[index++] = a[i];
        }

        return result;
    }


    static void printList(int[] result) {
        System.out.print("Final result of the merge lists: " );
        for(int i=0; i <result.length; i++) {
            System.out.print( " " + result[i]);
        }

    }


}
