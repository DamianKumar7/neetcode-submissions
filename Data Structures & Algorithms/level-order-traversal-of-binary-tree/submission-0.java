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
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer>list = new ArrayList<>();
            int n = queue.size();
            for(int i =0; i <n; i++){
                TreeNode ele = queue.poll();
                list.add(ele.val);
                if(ele.left != null){
                    queue.add(ele.left);

                }
                if(ele.right != null){
                    queue.add(ele.right);
                }
            }
            ans.add(list);

        }
        return ans;
        
    }
}
