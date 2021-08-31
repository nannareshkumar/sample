package trees;

/**
 * Created by home on 3/7/2021.
 */
public class BalancedTree {

    public static void main(String rag[]) {

        BalancedTree bt = new BalancedTree();
        TNode t = new TNode(2, null, new TNode(3, null, new TNode(4, null, new TNode(5, null, new TNode(6, null, null)))));

        System.out.println(" TreeBalanced: " + bt.checkBalanced(t));
    }

    public boolean checkBalanced(TNode root) {

        boolean isBal = false;
        if (root != null) {
            int lh = 0, rh = 0;

            if (root.left != null)
                lh = height(root.left);
            if (root.right != null)
                rh = height(root.right);
            if (Math.abs(lh - rh) < 1)
                isBal = true;
            else
                isBal = false;
        }
        return isBal;
    }

    public int height(TNode root) {

        if (root == null)
            return 0;
        if (root != null) {
            int lh = height(root.left);
            int rh = height(root.right);

            if (lh > rh)
                return 1 + lh;
            else
                return 1 + rh;
        }
        return 1;
    }


}

    class TNode {
        int value;
        TNode left;
        TNode right;

        TNode(int v, TNode l, TNode r) {
            this.value = v;
            this.left = l;
            this.right = r;
        }
    }