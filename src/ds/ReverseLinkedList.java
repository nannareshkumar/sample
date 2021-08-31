package ds;

/**
 * Created by home on 5/29/2020.
 */
public class ReverseLinkedList {

    public static void main(String args[]) {
        // [1, 2, 8, 9, 12, 16]
        ListNode1 ln = new ListNode1(1,new ListNode1(2, new ListNode1(8, new ListNode1(9, new ListNode1(12, new ListNode1(16))) ) ));

        print(ln);
       ln = reverseLL(ln, null);
        print(ln);
    }

    public static ListNode1 reverseLL(ListNode1 head, ListNode1 prev){

        if(head == null)
            return null;

        ListNode1 tmp;
        ListNode1 curr;
        curr = head;

        while(curr != null && curr.val%2 == 0){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        //https://www.geeksforgeeks.org/reverse-even-elements-in-a-linked-list/
        // If elements were reversed then head
        // pointer needs to be changed
        if (curr != head)
        {
            head.next = curr;

            // Recur for the remaining linked list
            curr = reverseLL(curr, null);
            return prev;
        }

        // Simply iterate over the odd value nodes
        else
        {
            head.next = reverseLL(head.next, head);
            return head;
        }
    }

    public static void print(ListNode1 ln){
        System.out.println("Value of List:");
        while(ln !=null){
            System.out.print(" " + ln.val);
            ln = ln.next;
        }
        System.out.println("\n");
    }

}


 class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1() {}
     ListNode1(int val) { this.val = val; }
     ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
 }
