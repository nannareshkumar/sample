package array;

import java.util.Stack;

/**
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is maximum possible AND
 j < i AND
 A[j] < A[i]
 Elements for which no smaller element exist, consider next smaller element as -1.

 Input Format

 The only argument given is integer array A.
 Output Format

 Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
 For Example

 Input 1:
 A = [4, 5, 2, 10, 8]
 Output 1:
 G = [-1, 4, -1, 2, 2]
 Explaination 1:
 index 1: No element less than 4 in left of 4, G[1] = -1
 index 2: A[1] is only element less than A[2], G[2] = A[1]
 index 3: No element less than 2 in left of 2, G[3] = -1
 index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
 index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]

 Input 2:
 A = [3, 2, 1]
 Output 2:
 [-1, -1, -1]
 Explaination 2:
 index 1: No element less than 3 in left of 3, G[1] = -1
 index 2: No element less than 2 in left of 2, G[2] = -1
 index 3: No element less than 1 in left of 1, G[3] = -1

 A : [ 34, 35, 27, 42, 5, 28, 39, 20, 28 ]
        -1 34 -1 27 -1 5 28 -1 20
        -1 34 -1 27 -1 5 28 5 20

 39, 27, 11, 4, 24, 32, 32, 1

 */
public class LeftofArray {

    public static void main(String args[]) {
        int[] A = new int[]{34, 35, 27, 42, 5, 28, 39, 20, 28};
        LeftofArray la = new LeftofArray();
        la.print(A);
        //la.print(la.solution(A));
        la.print(la.prevSmaller(A));
    }

    public int[] prevSmaller(int[] A) {

        int [] res = new int[A.length];
        Stack<Integer> stack= new Stack<>();

        for(int i=0; i<A.length; i++){

            while(!stack.isEmpty() && stack.peek()>=A[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?-1:stack.peek();

            stack.push(A[i]);
        }

        return res;
    }

    public int[] solution(int[] A){

        int res = -1;
        int[] G = new int[A.length];
        if(A.length > 0){
            int min=res, prev=res;
            for(int i=0; i < A.length; i++){
                 if(i==0) {
                     G[i] = res;
                     prev = A[i];
                 }
                 else if(prev < A[i]) {
                     G[i] = prev;
                 } else if(min < A[i]) {
                    G[i] = min;
                 } else {
                     G[i] = res;
                     min = Math.min(prev, A[i]);
                 }

                prev = A[i];
            }
        }
    return G;

    }

    public void print(int[] A){
        System.out.println("");
        for(int i =0; i< A.length; i++){
            System.out.print(" " + A[i]);
        }

    }



}
