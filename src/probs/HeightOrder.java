package probs;

import java.util.*;

/**
 * Created by home on 1/9/2021.
 */
public class HeightOrder {

     public static void main(String args[]){
         int[] A = new int[]{ 86, 92, 49, 21, 62, 27, 90, 59 };//{5, 3, 2, 6, 1, 4};
         int[] B = new int[]{ 2, 0, 0, 2, 0, 2, 1, 3 };//{0, 1, 2, 0, 3, 2};

         int[][] p = new int[][] { {86,2},{92,0},{49,2},{21,0},
                                   {62,2},{27,2},{90,1},{59,3}
                                 };


         HeightOrder ho = new HeightOrder();
         int[][] res = ho.reconstructQueue(p);
         for(int i=0; i <res.length; i++) {
             System.out.print(" " + res[i][0]);
         }
     }


    public int[][] reconstructQueue(int[][] people) {



        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][1]);


//        int[][] result = new int[people.length][];
//        Arrays.sort(people,new Comparator<int[]>(){
//            public int compare(int[] o1,int[] o2){
//                if(o1[0]!=o2[0])
//                    return o2[0]-o1[0];
//                else
//                    return o1[1]-o2[1];
//            }
//        });
//        List<int[]> list = new ArrayList<int[]>();
//        for(int i=0;i<people.length;i++){
//            int[] arr = people[i];
//            list.add(arr[1],arr);
//        }
//        for(int i=0;i<people.length;i++){
//            result[i] = list.get(i);
//        }
//        return result;
    }


        public int[] order(int[] A, int[] B) {

            int[] res = new int[A.length];
            Map<Integer, Integer> m = new TreeMap(Collections.reverseOrder());
            for(int i = 0 ; i <A.length; i++){
                m.put(A[i], B[i]);
            }

            for(Map.Entry<Integer, Integer> iter : m.entrySet()){
              Integer val = iter.getValue();
              Integer key = iter.getKey();

            }
//            while(iter.hasNext()){
//                Map.Entry<Integer, Integer> item =  (Map.Entry<Integer, Integer>)  iter.next();
//                item.
//            }



//
//            int[] res = new int[A.length];
//            Map<Integer, Integer> m = new HashMap();
//            for(int i=0; i<A.length; i++ ){
//                m.put(A[i], B[i]);
//            }
//            Arrays.sort(B);
//
//            //86, 92, 49, 21, 62, 27, 90, 59
//            //2,   0,  0,  2,  0,  2,  1,  3
//            //49,  62  21, 27, 92  90  59 86
//            // 0,  0,  2,  2,  0,  1,  3   2
//            for(int index=0; index < B.length; index++){
//
//
//                if(B[index] > i){
//
//                }
//
//            }
//            return res;
//        }
//
//        public int[] forward(int[] A, int len, int base, int[] res ){
//         int ind =0;
//         for(int i =0; i < A.length; i++){
//             if(A[i] > base)
//                 res[ind++] = A[i];
//         }
         return res;
        }
//
//
//        public void swap(int[] A, int[] B, int start, int end, int[] res){
//            int temp;
//            temp = A[start];
//            A[start] = A[end];
//            A[end] = temp;
//
//            temp = B[start];
//            B[start] = B[end];
//            B[end]= temp;
//
//            res[start] = A[start];
//            res[end] = A[end];
//        }
//
//        static class TreeNode{
//            int val;
//            TreeNode left;
//            TreeNode right;
//
//            TreeNode(int value){
//                this.val = value;
//            }
//
//        }


    }