package interviewbit;
import java.util.*;

public class ReorderLinkedList {

    public static void main(String args[]){
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
//        A : [ 12 -> 6 -> 75 -> 98 -> 58 -> 81 -> 30 -> 101 -> 87 -> 40 -> 70 -> 45 -> 41 -> 20 -> 66 -> 1 -> 96 -> 35 -> 51 -> 79 -> 61 -> 48 -> 99 -> 11 -> 32 -> 88 -> 60 -> 18 -> 42 -> 29 -> 13 -> 91 -> 85 -> 10 -> 33 -> 52 -> 84 -> 4 -> 94 -> 46 -> 23 -> 82 -> 59 -> 38 -> 97 -> 17 -> 14 -> 90 -> 54 -> 69 -> 57 -> 74 -> 73 -> 39 ]

        ReorderLinkedList r = new ReorderLinkedList();
        ListNode res = r.reorderList(ln);
        while(res !=null){
            System.out.println(" " + res.val);
            res = res.next;
        }
    }


    public ListNode reorderList(ListNode A) {

        ListNode slow = A, fast = slow.next;
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node1 = A;
        ListNode node2 = slow.next;
        slow.next = null;

        node2 = reverse(node2);
        ListNode no = new ListNode(0);
        ListNode curr= no;

        while(node1 != null || node2 != null){
            if(node1 != null){
                curr.next = node1;
                curr = node1;
                node1 = node1.next;
            }

            if(node2 != null ){
                curr.next = node2;
                curr = node2;
                node2 = node2.next;
            }

        }
        return no.next;
    }


    public ListNode reverse(ListNode node){
        ListNode prev=null, curr=node, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public ListNode reorderList2(ListNode A) {
        Stack<ListNode> stack = new Stack();

        ListNode curr = A;
        while (curr != null) {
            System.out.println(" "+ curr.val);
            stack.push(curr);
            curr = curr.next;
        }

        ListNode prev = null, last;
        curr = A;// int count=0, mid=(stack.size()+1)/2;
        while (curr != null && !stack.isEmpty()){  // && count != mid) {
            last = (ListNode) stack.peek();
            if( prev != null && prev.equals(last)){
               curr.next = null;
            }
            prev = curr.next;
            curr.next = last;
            last.next = prev;
            curr = prev;
            stack.pop();
            //count++;
        }

        return A;
    }
}

   class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
