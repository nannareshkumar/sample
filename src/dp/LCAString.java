package dp;

import java.util.*;

public class LCAString {

    private static int max=0;
    public static void main(String[] args) {
        String[] words1 ={"cat", "baby","dog", "bird", "car", "ax"};
        String[] words2 ={"gdgdfg", "fdfdf","cat","baby","dog", "car", "ax", "gfdgdgg"};

        Set<String> set = findContiguousHistory(words1, words2);
        System.out.println("Results:");
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            System.out.println(" " + iter.next());
        }
    }

    static Set<String> findContiguousHistory(String[] arr1, String[] arr2) {
        /*
            Approach 1: Using DP
            Time - O(mn)
            Space - O(n)
        */
        int m = arr1.length;
        int n = arr2.length;

        Set<String> result = new HashSet<>();
        List<Set<String>> previous = new ArrayList<Set<String>>();
        List<Set<String>> current = new ArrayList<Set<String>>();

        for(int i = 0; i <= m; i++) {
            previous.add(new HashSet<String>());
        }
        current.add(0, new HashSet<String>());

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr1[j-1].equals(arr2[i-1])) {
                    Set<String> set = new HashSet<String>();
                    set.addAll(previous.get(j-1));
                    set.add(arr2[i-1]);
                    current.add(j, set);
                } else {
                    current.add(j, new HashSet<>());
                }
                if(current.get(j).size() > result.size()) {
                    result = new HashSet<>();
                    result.addAll(current.get(j));
                }
            }
            previous = new ArrayList<Set<String>>();
            previous.addAll(current);
        }
        return result;
    }

}
