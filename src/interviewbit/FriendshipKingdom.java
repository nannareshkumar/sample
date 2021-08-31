package interviewbit;

import java.util.*;

public class FriendshipKingdom {

    public static void main(String args[]){
        int[]  A = new int[]{3,2,1};
        FriendshipKingdom fk = new FriendshipKingdom();
        int res = fk.frienshipPairs(A);
        System.out.println("Number of Best friends pairs: " + res);
    }

    public int frienshipPairs(int[] A){

        int count = 0;
        Map<Integer, Integer> map = new HashMap();

        for(int i=A.length-1; i >0; i-- ){
            map.put(A[i], A[i-1]);
        }
        map.put(A[0], A[A.length-1]);

        Set<Map.Entry<Integer, Integer>> res = new HashSet();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer>  item = (Map.Entry<Integer, Integer>) iter.next();
            Integer key = item.getKey();
            Integer val = item.getValue();

            if(key == map.get(val)){
                if(key < val) {
                    res.add(item);
                }
            }
        }
        return res.size();
    }

}
