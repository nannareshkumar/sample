package interviewbit;

import java.util.*;

public class MinDepth {

    public static void main(String args[]){
        MinDepth md = new MinDepth();
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.left.right = new TreeNode(3);

        System.out.println(" result :" + md.minDepth(tn));
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        return bfs(root);
    }

    private int bfs (TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int minLevel = 0;

        while (!queue.isEmpty()) {
            //loop through the size of the queue
            int queueSize = queue.size();
            minLevel++;

            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left == null && curr.right == null) {
                    return minLevel;
                }
            }
        }
        return minLevel;
    }

static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

}