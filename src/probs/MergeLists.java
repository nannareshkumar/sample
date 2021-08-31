package probs;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


//https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
// Solution is taken from the above site

class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class MergeLists {

    public static void main(String args[]){

        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3, new ListNode(4)));

        ListNode result = mergeTwoLists(l1, l2);


        while(result.next != null){
            System.out.println("value of " + result.val);
            result = result.next;
        }

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Solution taken from https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
        ListNode head = new ListNode(0);
        ListNode p=head;

        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p=p.next;
        }

        if(p1!=null){
            p.next = p1;
        }

        if(p2!=null){
            p.next = p2;
        }

        return head.next;
    }

}


