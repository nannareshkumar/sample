package trees;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

     1
   /  \
 2     3
     /
    4
   /
 5
 min depth = 2.
 */
public class MinDepth {

    public static void main(String args[]){
//        TreeNode left = new TreeNode(2, null, null);
//        TreeNode right = new TreeNode(3, new TreeNode(4, new TreeNode(5, null, null), null), null);
//[2,null,3,null,4,null,5,null,6]
        TreeNode t = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null)))));

        MinDepth md = new MinDepth();
        System.out.println("result :" + md.minDepth(t));

    }

    public int minDepth(TreeNode root){

        if(root == null)
            return 0;
        else{
           return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }

    }




}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int v, TreeNode l, TreeNode r){
        this.value = v;
        this.left = l;
        this.right = r;
    }
}
