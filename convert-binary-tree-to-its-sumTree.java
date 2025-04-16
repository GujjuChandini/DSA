// naukari.com striver
/************************************************************

    Following is the TreeNode class structure:

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {
    
    public static int helper(TreeNode<Integer> root){
        if(root == null) return 0;

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        int oldVal = root.data;

        root.data = leftSum + rightSum; 

        return oldVal+root.data; 
    }

    public static TreeNode<Integer> convertToSumTree(TreeNode<Integer> root) {
        helper(root);
        return root;
    }
}
