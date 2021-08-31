package array;

import java.util.*;
import java.io.*;

public class PartitionArray {

    static int counter = 0;

    public static void main(String args[]){
        int n = 3;
        int k = 2;

        ArrayList<List<Integer>> ans = new ArrayList();
        for(int i =0; i<k; i++){
            ans.add(new ArrayList());
        }
        solution(1, n, k, 0 , ans);
    }

    public static void solution(int i, int n, int k, int nos, List<List<Integer>> ans){

        if(i > n){
            if(nos == k) {
                counter++;
                System.out.println(counter  +  ". ");
                for(List<Integer> set: ans){
                    System.out.println(set + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int j=0; j< ans.size(); j++){
            if(ans.get(j).size() > 0 ){
                ans.get(j).add(i);
                solution(i+1, n,  k,nos+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);
            } else {
                ans.get(j).add(i);
                solution(i+1, n,  k,nos+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);
                break;
            }

        }

    }

}
