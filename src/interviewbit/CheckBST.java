package interviewbit;

/**
 * Created by home on 3/1/2021.
 */
public class CheckBST {

    public static void main(String args[]){

    }

    public boolean checkBST(Node n){

        boolean result = false;
        if( n.leftNode != null && n.rightNode != null){
            if(n.value < n.leftNode.value && n.value > n.rightNode.value)
                result = true;
        }
        checkBST(n.leftNode);
        checkBST(n.rightNode);
        return result;
    }

    public void insert(Node n, int v){

        if( v < n.value){
            insert(n.leftNode, v);
        } else if(v > n.value){
            insert(n.rightNode, v);
        }
    }
}

class Node {
    int value;
    Node leftNode = null;
    Node rightNode = null;

    Node(int v, Node l, Node r){
        this.value = v;
        this.leftNode = l;
        this.rightNode = r;
    }

}