package ds;

import java.util.*;

/**
 * Created by home on 1/5/2021.
 */
public class Permutations {

    public static void main(String args[]){

        int[] a = new int[]{1,2,3};
        Permutations p = new Permutations();
        List<int[]> res = p.listPermutations(a);

        Iterator iter = res.iterator();
        while(iter.hasNext()){
           int[] arr = (int[]) iter.next();
           for(int i =0; i < arr.length; i++){
               System.out.print(" " + arr[i]);
           }
           System.out.println(" ");
        }

    }


    public ArrayList<String> stringPermutations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        stringPermutations("", s, result);
        return result;
    }

    private void stringPermutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
            }
        }
    }

    public List<int[]> listPermutations(int[] a) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        listPermutations(a, 0, results);
        return results;
    }

    private void listPermutations(int[] a, int start, List<int[]> result) {
        if (start >= a.length) {
            result.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                listPermutations(a, start + 1, result);
                swap(a, start, i);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}