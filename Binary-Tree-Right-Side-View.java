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
        List<Integer> rightview = new ArrayList<>();
        int level = 0;
        helper(root, level, rightview);
        return rightview;
    }
    public static void helper(TreeNode root, int level, List<Integer> rightview){
        if(root==null){
            return;
        }

        if(rightview.size()==level){
            rightview.add(root.val);
        }
        helper(root.right, level+1, rightview);
        helper(root.left, level+1, rightview);
    }
}