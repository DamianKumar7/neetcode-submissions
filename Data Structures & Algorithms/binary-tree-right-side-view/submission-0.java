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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int val = 0;
            for(int i =0; i <size; i++){
                TreeNode ele = queue.poll();
                val = ele.val;
                if(ele.left != null){
                    queue.add(ele.left);
                }
                if(ele.right != null){
                    queue.add(ele.right);
                }
            }
            ans.add(val);
        }
        return ans;
    }
}
