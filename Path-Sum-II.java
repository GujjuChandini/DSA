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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && remaining == node.val) {
            res.add(new ArrayList<>(path));
        }

        dfs(node.left, remaining - node.val, path, res);
        dfs(node.right, remaining - node.val, path, res);

        path.remove(path.size() - 1);
    }
}
