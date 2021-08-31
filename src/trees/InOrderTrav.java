package trees;

public class InOrderTrav {

    public static void main(String args[]){

       Node n = new Node( 5,
               new Node(2, new Node(1, null, null),
                       new Node(3, null, null)),
               new Node(7, new Node(6, null, null), new Node(8, null, null)));

       InOrderTrav in = new InOrderTrav();
       in.inOrder(n);
    }

    public void inOrder(Node root){

        if(root.left != null){
            inOrder(root.left);
        }
        System.out.println( " " + root.val);

        if(root.right != null){
            inOrder(root.right);
        }

    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int v, Node left, Node right){
        val = v;
        this.left = left;
        this.right = right;
    }

}
