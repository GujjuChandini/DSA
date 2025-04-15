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
        if(root==null) return result;
        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> answer = new LinkedList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(leftToRight){
                    if(curr!=null)
                        answer.addLast(curr.val);
                }else{
                    if(curr!=null)
                        answer.addFirst(curr.val);
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }

            result.add(answer);
            leftToRight = !leftToRight;
        }
        return result;
    }
}