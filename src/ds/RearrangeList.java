package ds;

/**
 * Given a singly linked list

 L: L0 → L1 → … → Ln-1 → Ln,
 reorder it to:

 L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 You must do this in-place without altering the nodes’ values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class RearrangeList {

    public static void main(String args[]){
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);

        RearrangeList  rl = new RearrangeList();

        ListNode node = rl.reorderList(ls);
        while(node != null ){
            System.out.print(" " + node.val);
            node = node.next;
        }

    }


    public ListNode reorderList(ListNode A) {

        ListNode rev = reverseList(A);
        ListNode temp;
        while (A.next != null) {
            temp = A.next;
            A.next = rev;
            A.next.next = temp;
        }
        return A;
    }

    //{1,2,3,4}    {1,4,2,3}
    public ListNode reverseList(ListNode A) {

        ListNode prev = null, curr = A, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }


  static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
