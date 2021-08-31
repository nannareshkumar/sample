package threads; /**
 * Created by home on 3/3/2020.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IPAddrMatch {

    static final String IPV4_REGEX = "^((\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])$";
    static final String IPV6_REGEX = "^([0-9a-f]{1,4}:){7}[0-9a-f]{1,4}$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        for (int tc = 0; tc < N; tc++) {
            String line = sc.nextLine();

            if (isIPv4(line)) {
                System.out.println("IPv4");
            } else if (isIPv6(line)) {
                System.out.println("IPv6");
            } else {
                System.out.println("Neither");
            }
        }

        sc.close();
    }

    static boolean isIPv4(String s) {
        return s.matches(IPV4_REGEX);
    }

    static boolean isIPv6(String s) {
        return s.matches(IPV6_REGEX);
    }

    static boolean another() throws Exception {

        boolean result = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] ip = new String[n];
        for(int i = 0;i<n;i++){
            ip[i] = br.readLine();
        }
        for (int i= 0 ; i<n; i++){
           validate(ip[i]);
        }

        return result;
    }

    public static void validate(final String ip){
        Pattern pat;
        Matcher match;
        String ip4 = "IPv4";
        String ip6 = "IPv6";
        String non = "Neither";
        final String ipv4 =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        final String ipv6 =
                "^[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:" +
                        "[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:" +
                        "[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}:" +
                        "[0-9a-f]{1,4}:" + "[0-9a-f]{1,4}$";

        if(ip.indexOf(".")>0){
            pat = Pattern.compile(ipv4);
            match = pat.matcher(ip);
            if(match.matches()){
                System.out.println(ip4);
            }else{
                System.out.println(non);
            }
        }else if (ip.indexOf(":")>0){
            pat = Pattern.compile(ipv6);
            match = pat.matcher(ip);
            if(match.matches()){
                System.out.println(ip6);
            }else{
                System.out.println(non);
            }
        }else{
            System.out.println(non);
        }
    }

}

