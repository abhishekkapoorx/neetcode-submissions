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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode top = q.poll();
                level.add(top.val);

                // add its node to queue
                if (top.left!=null) q.offer(top.left);
                if (top.right!=null) q.offer(top.right);
            }
            res.add(level);
        }
        return res;
    }
}
