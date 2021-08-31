package probs;

import java.rmi.UnexpectedException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by home on 10/8/2020.
 */
public class DistinctYears {

    public static void main(String args[]){

        String s1 = "UN was established on 24-10-1945. India got freedom on 15-08-1947.";
        String s2 = "Soon after the world war 2 ended on 02-09-1945. The UN was established on 24-10-1945.";

        System.out.println(" number of years : " + findYears(s1));
        System.out.println(" number of years : " + findYears(s2));
    }


    public static int findYears(String s){

        if(s.length() <= 0 )
            return 0;

        Set<Integer> years = new HashSet();
        StringTokenizer st =  new StringTokenizer(s, "-");
        boolean first = true;
        while(st.hasMoreElements()){
            st.nextToken();
            if(first) {
                st.nextToken();
                first = false;
            }
            String ele = st.nextToken();
            String str = ele.substring(0,4);
            System.out.println("value of str :" + str);
            years.add(Integer.parseInt(str));

        }
        return years.size();
    }

}
