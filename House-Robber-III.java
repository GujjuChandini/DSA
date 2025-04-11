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
    // Helper method that returns an array:
    // res[0] = max amount if current node is NOT robbed
    // res[1] = max amount if current node IS robbed
    public int[] subRob(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0}; // base case
        }

        // Recurse on left and right children
        int[] left = subRob(root.left);
        int[] right = subRob(root.right);

        int[] res = new int[2];
        
        // If root is not robbed, we can choose to rob or not rob children
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // If root is robbed, children cannot be robbed
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public int rob(TreeNode root) {
        int[] result = subRob(root); // get result from helper
        return Math.max(result[0], result[1]); // max of robbing or not robbing root
    }
}
