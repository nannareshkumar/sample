package karat;

import java.util.*;

public class URLDomainsAndCount {

        public static void main(String args[]) {

            String[]  counts = new String[] {
                        "900,google.com",
                        "60,mail.yahoo.com",
                        "10,mobile.sports.yahoo.com",
                        "40,sports.yahoo.com",
                        "300,yahoo.com",
                        "10,stackoverflow.com",
                        "20,overflow.com",
                        "5,com.com",
                        "2,en.wikipedia.org",
                        "1,m.wikipedia.org",
                        "1,mobile.sports",
                        "1,google.co.uk"
            };

            List<String> list = subdomainVisits(counts);

            Iterator iter = list.iterator();
            while(iter.hasNext()) {
             System.out.println(" results : " + (String)  iter.next());
            }

        }

        public static List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> counts = new HashMap();
            for (String domain: cpdomains) {
                String[] cpinfo = domain.split(",");
                String[] frags = cpinfo[1].split("\\.");
                int count = Integer.valueOf(cpinfo[0]);
                String cur = "";
                for (int i = frags.length - 1; i >= 0; --i) {
                    cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                    counts.put(cur, counts.getOrDefault(cur, 0) + count);
                }
            }

            List<String> ans = new ArrayList();
            for (String dom: counts.keySet())
                ans.add("" + counts.get(dom) + " " + dom);
            return ans;
        }
   }
