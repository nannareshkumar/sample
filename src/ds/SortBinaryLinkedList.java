package ds;

/**
 * Created by home on 1/5/2021.
 */
public class SortBinaryLinkedList {

    public static void main(String args[]){
        //1 -> 0 -> 0 -> 1
        ListNodeB lb = new ListNodeB(1);
        lb.next = new ListNodeB(0);
        lb.next.next = new ListNodeB(0);
        lb.next.next.next = new ListNodeB(1);

        System.out.println("Given list before the sorting: ");
        printlist(lb);
        System.out.println("\n After sorting: ");
        ListNodeB res =  sort(lb);
        printlist(res);

    }

    public static ListNodeB sort(ListNodeB head){

        ListNodeB curr= head, node0 = new ListNodeB(0), node1 = new ListNodeB(1);

        while(curr != null){

            if(curr.val == 0) {
                node0= new ListNodeB(curr.val);
            }else {
                node1= new ListNodeB(curr.val);
            }

            if(curr.next != null && curr.next.val == 0){
                node0.next = curr.next;
            } else if(curr.next != null && curr.next.val == 1) {
                node1.next = curr.next;
            }

            curr = curr.next;
        }

        while(node0 != null){
            curr = node0;
            node0 = node0.next;
        }

        while(node1 != null){
            curr = node1;
            node1 = node1.next;
        }

        return curr;

    }
    static void printlist(ListNodeB node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    static class ListNodeB {
        public int val;
        public ListNodeB next;

        ListNodeB(int x) {this.val = x;}
        ListNodeB(int x, ListNodeB next) {
            this.val = x;
            this.next = next;
        }
    }


}
