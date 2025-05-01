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
    int preIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = postorder.length;
        for(int i=0;i<n;i++){
            map.put(postorder[i], i);
        }
        return helper(preorder, postorder, map, 0, n-1, n);
    }
    public TreeNode helper(int[] pre, int[] post, Map<Integer, Integer> map, int postStart, int postEnd, int n){
        if(preIndex >= n || postStart > postEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;

        if(postStart==postEnd || preIndex >= n){
            return root;
        }

        int rootleft = pre[preIndex];
        int postIndex = map.get(rootleft);

        root.left = helper(pre, post, map, postStart, postIndex, n);
        root.right = helper(pre, post, map, postIndex+1, postEnd-1, n);

        return root;
    }
}