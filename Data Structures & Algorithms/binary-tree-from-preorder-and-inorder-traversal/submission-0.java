class Solution {

    private TreeNode buildT(
        Map<Integer, Integer> inMap,
        int[] preorder,
        int preStart,
        int preEnd,
        int inStart,
        int inEnd
    ) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIdx = inMap.get(root.val);
        int leftSize = rootIdx - inStart;

        root.left = buildT(
            inMap,
            preorder,
            preStart + 1,
            preStart + leftSize,
            inStart,
            rootIdx - 1
        );

        root.right = buildT(
            inMap,
            preorder,
            preStart + leftSize + 1,
            preEnd,
            rootIdx + 1,
            inEnd
        );

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildT(
            inMap,
            preorder,
            0,
            preorder.length - 1,
            0,
            inorder.length - 1
        );
    }
}