package bytebybyte;

import java.util.*;

/**
 * Created by home on 3/5/2021.
 */
public class Permutations {

    public static void main(String args[]){
        String s = "123";
        Permutations p = new Permutations();
        List<String> results = new ArrayList();
        p.stringPermutations("", s, results);

        for (int i = 0; i < results.size(); i++) {
            System.out.println(" " + results.get(i));
        }

    }

    public ArrayList<String> stringPermutations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        stringPermutations("", s, result);
        return result;
    }

    private void stringPermutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            System.out.println( " results: " + prefix);
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                System.out.println(" prefix:" + prefix + suffix.charAt(i) + " suffix:" + suffix.substring(0, i) + suffix.substring(i+1, suffix.length()) );
                stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, suffix.length()), results);
            }
        }
    }



}
