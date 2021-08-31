package karat;

import java.util.*;

public class ParentChildPair {

    public static void main(String args[]){
        int[][] parent_child_pairs = {  {1, 3},{2, 3},{3, 6},{5, 6},{15, 9},
                                        {5, 7},{4, 5},{4, 8},{4, 9},{9, 11}, {12, 9} };
        List<List<Integer>> results = find_nodes_with_zero_and_one_parents(parent_child_pairs);

        Iterator ter = results.iterator();
        while(ter.hasNext()){
            List<Integer> pc =  (List<Integer>)ter.next();
            Iterator it = pc.iterator();
            while(it.hasNext()){
               Integer res = (Integer) it.next();
               System.out.print(" " + res);
            }
            System.out.println(" ");
        }

    }

    public static List<List<Integer>> find_nodes_with_zero_and_one_parents(int[][] parent_child_pairs) {
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        int max =-1;
        for (int[] pair : parent_child_pairs) {
            nodes.add(pair[0]);
            nodes.add(pair[1]);
            Integer count = indegree.get(pair[1]);
            if(count == null)
                count = 1;
            else
                count++;
            indegree.put(pair[1], count);
            if(max < count)
                max = count;
        }
        List<Integer> zero_parents = new ArrayList<>();
        List<Integer> one_parent = new ArrayList<>();
        List<Integer> most_parent = new ArrayList<>();
        for (int node : nodes) {
            int parents = indegree.getOrDefault(node, 0);
            if (parents == 0) {
                zero_parents.add(node);
            } else if (parents == 1) {
                one_parent.add(node);
            } else if(parents == max){
                most_parent.add(node);
            }
        }
        return List.of(zero_parents, one_parent, most_parent);
    }
}
