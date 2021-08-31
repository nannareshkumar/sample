package probs;

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
class AddLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result =new ListNode();
        ListNode next = new ListNode();

        int a  =  Integer.valueOf(reverse(l1));
        int b  =  Integer.valueOf(reverse(l2));

        String s = "" + (a+b);

        for(int i = 0; i < s.length(); i++){
            result = new ListNode(s.indexOf(i), next);
            result = next;
        }

        System.out.println(" Addition:" + (a+b));
        return result;
    }

    public ListNode populate(ListNode ln, int v, ListNode n) {
        ln.val = v;
        ln.next = n;
        return ln;
    }

    public String reverse(ListNode l1){

        String result="", s = "";
        while(l1 !=null) {
            s = s + Integer.toString(l1.val);
            l1 = l1.next;
        }
        if(!s.isEmpty()){
           for(int i= s.length()-1; i >=0; i++)
               result = result+s.charAt(i);
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}