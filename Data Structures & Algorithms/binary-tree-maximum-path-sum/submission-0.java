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

class Solution {
    // global, local
    private int[] pathSum(TreeNode root){
        if (root == null) return new int[]{0, 0};
        
        int[] left = pathSum(root.left);
        int[] right = pathSum(root.right);

        int globalMaxLeftRight = Math.max(left[0], Math.max(right[0], 0));
        int localMaxLeftRight = Math.max(left[1], Math.max(right[1], 0));

        int pos1 = Math.max(globalMaxLeftRight, Math.max(root.val + left[1] + right[1], 0));
        int pos2 = Math.max(root.val + localMaxLeftRight, 0);
        return new int[]{pos1, pos2};

    }
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        int[] res = pathSum(root);
        return Math.max(res[0], res[1]);      
    }
}
