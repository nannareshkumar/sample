package interviewbit;

public class SumPathBinaryTree {

    public static void main(String args[]){
        TreeNode t = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        SumPathBinaryTree s = new SumPathBinaryTree();
        System.out.println(" result" + s.maxPathSum(t));
    }

    public int maxPathSum(TreeNode root) {

        return sumSubTree(root);
    }

    public int sumSubTree(TreeNode root) {

        if (root == null)
            return 0;
        else {
            int left = sumSubTree(root.left);
            int right = sumSubTree(root.right);
            int total = left + root.val + right;

            System.out.println(" " + total);

            if (left < 0 || right < 0 || root.val < 0) {
                return Math.max(Math.max(left, right), root.val);
            } else {
                return total;
            }

        }


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


