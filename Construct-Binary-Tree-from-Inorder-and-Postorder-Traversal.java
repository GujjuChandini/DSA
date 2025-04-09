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
    public int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        postIndex = size-1;
        int inStart = 0;
        int inEnd = size-1;

        return helper(inorder, postorder, inStart, inEnd);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(postIndex < 0 || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = search(inorder, root.val);
        postIndex--;

        root.right = helper(inorder, postorder, index+1, inEnd);
        root.left = helper(inorder, postorder, inStart, index-1);

        return root;
    }
    public int search(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}