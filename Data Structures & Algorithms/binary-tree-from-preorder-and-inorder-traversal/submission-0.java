class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(
            preorder,
            0,
            preorder.length - 1,
            inorder,
            0,
            inorder.length - 1,
            map
        );
    }

    private TreeNode build(
            int[] preorder,
            int preStart,
            int preEnd,
            int[] inorder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> map) {

        // No elements to construct
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // First element of preorder is the root
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;

        // Build left subtree
        root.left = build(
            preorder,
            preStart + 1,
            preStart + leftSize,
            inorder,
            inStart,
            rootIndex - 1,
            map
        );

        // Build right subtree
        root.right = build(
            preorder,
            preStart + leftSize + 1,
            preEnd,
            inorder,
            rootIndex + 1,
            inEnd,
            map
        );

        return root;
    }
}