package ds;

/**
 *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        from the end of list and return its head.

 For example,
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNLL {

    public static void main(String args[]){
        ListNodeR ln = new ListNodeR(1);
        ln.next = new ListNodeR(2);
        ln.next.next = new ListNodeR(3);
        ln.next.next.next = new ListNodeR(4);
        ln.next.next.next.next = new ListNodeR(5);

        printlist(ln);
        int size = nodeLength(ln);
        int val =size-1;
        System.out.println(" length of the list: " + size);
        removeNthFromEnd(ln, val);
        printlist(ln);
    }
    //  1-> 2addres -> 2 -> 2addres -> 3 -3 address
// Function to remove nth node from last
    /*
    A : [ 20 -> 380 -> 349 -> 322 -> 389 -> 424 -> 429 -> 120 -> 64 -> 691 -> 677 -> 58 -> 327 -> 631 -> 916 -> 203 -> 484 -> 918 -> 596 -> 252 -> 509 -> 644 -> 33 -> 460 ]
          20 -> 380 -> 349 -> 322 -> 389 -> 424 -> 429 -> 120 -> 64 -> 691 -> 677 -> 58 -> 327 -> 631 -> 916 -> 203 -> 484 -> 918 -> 596 -> 252 -> 509 -> 644 -> 33 -> 460
                380 -> 349 -> 322 -> 389 -> 424 -> 429 -> 120 -> 64 -> 691 -> 677 -> 58 -> 327 -> 631 -> 916 -> 203 -> 484 -> 918 -> 596 -> 252 -> 509 -> 644 -> 33 -> 460
    B : 82
     */
    static ListNodeR removeNthFromEnd(ListNodeR head, int B){
        if(head == null)
            return null;

        int fromStart = B-1;
        if(fromStart==1)
            return head.next;

        ListNodeR p = head, tmp = head;
        int i=0;
        while(p!=null){
            i++;
            if(i==B-1){
                p.next = p.next.next;
            }
            p=p.next;
        }
        return head;
    }

    static int nodeLength(ListNodeR node){
        int count=0;
        ListNodeR curr = node;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }

    static void printlist(ListNodeR node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    static class ListNodeR {
        public int val;
        public ListNodeR next;

        ListNodeR(int x) {
            val = x;
            next = null;
        }
    }
}
