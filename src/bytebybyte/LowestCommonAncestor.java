package bytebybyte;

import java.util.*;

public class LowestCommonAncestor {

    Node root;

    public static void main(String args[]){

        LowestCommonAncestor tree = new LowestCommonAncestor();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node res = tree.lca(tree.root, tree.root.left,  tree.root.left.left );
        System.out.println("result : " + res.val);
    }

    public Node lca(Node tree, Node n1, Node n2) {
        if (n1.equals(n2)) return n1;

        Stack pathToN1 = pathTo(tree, n1);
        Stack pathToN2 = pathTo(tree, n2);
        if (pathToN1 == null || pathToN2 == null) return null;

        Node prev = null;
        while (!pathToN1.isEmpty() && !pathToN2.isEmpty()) {
            Node s = (Node) pathToN1.pop();
            Node t = (Node) pathToN2.pop();
            if (s.equals(t)) prev = s;
            else break;
        }

        return prev;
    }

    public Stack<Node> pathTo(Node tree, Node n) {
        if (tree == null) return null;
        if (tree.equals(n)) {
            Stack<Node> s = new Stack<Node>();
            s.push(tree);
            return s;
        }

        Stack<Node> left = pathTo(tree.left, n);
        Stack<Node> right = pathTo(tree.right, n);

        if (left != null) {
            left.push(tree);
            return left;
        }

        if (right != null) {
            right.push(tree);
            return right;
        }

        return null;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }


  }
