package array;

import java.util.*;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

 Note:

 1) Return the indices `A1 B1 C1 D1`, so that
 A[A1] + A[B1] = A[C1] + A[D1]
 A1 < B1, C1 < D1
 A1 < C1, B1 != D1, B1 != C1

 2) If there are more than one solutions,
 then return the tuple of values which are lexicographical smallest.

 Assume we have two solutions
 S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 S2 : A2 B2 C2 D2

 S1 is lexicographically smaller than S2 iff
 A1 < A2 OR
 A1 = A2 AND B1 < B2 OR
 A1 = A2 AND B1 = B2 AND C1 < C2 OR
 A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 Example:

 Input: [3, 4, 7, 1, 2, 9, 8]
 Output: [0, 2, 3, 5] (O index)
 If no solution is possible, return an empty list.
 */
public class SumValues {

 public static void main(String ars[]){
     int[] A = new int[]{ 3, 4, 7, 1, 2, 9, 8};
     List<List> res = new ArrayList();

     findSumValues(A, res);

     Iterator iter = res.iterator();
     while(iter.hasNext()){
      List<List>  list = (List<List>)  iter.next();
      Iterator iter1 =  list.iterator();
      while(iter1.hasNext()){
         int l = (int)iter1.next();
          System.out.print(" " + l);
         }
       String s1 = "abcd", s2= "cdba";



      System.out.println(" ");
     }

 }

 public static void findSumValues(int[] A, List<List> res){

     int n = A.length, sum=0;
     Map<Integer, List> map = new HashMap();
     for(int i =0; i< n; i++){
         for(int j =i+1; j< n-1; j++) {
             sum = A[i] + A[j];
             List ex = map.get(sum);
             if (ex == null) {
                 List list = new ArrayList();
                 list.add(i); list.add(j);
                 map.put(sum, list);
             } else {
                 ex.add(i); ex.add(j);
                 res.add(new ArrayList(ex));
             }
         }
     }

 }


}
