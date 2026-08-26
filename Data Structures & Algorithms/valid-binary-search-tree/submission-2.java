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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return helper(root, min, max);
    }

    public boolean helper(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val>=max || root.val <=min){
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
