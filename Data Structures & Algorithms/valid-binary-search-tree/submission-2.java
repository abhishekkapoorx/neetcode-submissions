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
    private boolean findValid(TreeNode root, int min_range, int max_range){
        if (root == null) return true;
        else if (root.val < min_range || root.val > max_range) return false;
        return findValid(root.left, min_range, root.val) && findValid(root.right, root.val, max_range);
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return findValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
