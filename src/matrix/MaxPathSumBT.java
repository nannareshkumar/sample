package matrix;

/**
 * Created by home on 12/29/2020.
 */
public class MaxPathSumBT {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public int maxPathSum(TreeNode root) {

        int ml=0, mr=0, result=0;
        result  = root.val;

        if(root.left != null){
            ml = maxPathSum(root.left);
            ml = (ml > 0) ? ml : 0;
        }
        if(root.right != null){
            mr = maxPathSum(root.right);
            mr = (mr > 0) ? mr : 0;
        }

        if(root.val > 0)
            result = result+ml+mr;
        else
            result = Math.max(ml, mr);

        return result;
    }


    public static void main(String args[]){
//        TreeNode left =  new TreeNode(9, null, null);
//        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
//        TreeNode node = new TreeNode(-10, left, right);
        TreeNode node = new TreeNode(1, new TreeNode(2), null);

        MaxPathSumBT bt = new MaxPathSumBT();
        System.out.println("Max path  :" + bt.maxPathSum(node) );
    }

 static class TreeNode {
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

}