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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        int index = 1;

        q.offer(root);
        q.offer(null);

        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                if (index % 2 == 1) {
                    result.add(new ArrayList<>(level));
                } else {
                    List<Integer> rev = new ArrayList<>();
                    while (!s.isEmpty()) {
                        rev.add(s.pop().val);
                    }
                    result.add(rev);
                }

                level = new ArrayList<>();
                index++;

                if (!q.isEmpty()) {
                    q.offer(null);
                }
                continue;
            }

            if (index % 2 == 1) {
                level.add(curr.val);
            } else {
                s.push(curr);
            }

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }

        return result;
    }
}
