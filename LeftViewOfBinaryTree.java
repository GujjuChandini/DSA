// https://www.naukri.com/code360/problems/left-view-of-binary-tree_625707?leftPanelTabValue=PROBLEM
/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
import java.util.*;

public class Solution {

    public static void printLeftView(TreeNode<Integer> root) {
        if (root == null) return;

        List<Integer> leftView = new ArrayList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);
        leftView.add(root.data);

        while (!q.isEmpty()) {
            TreeNode<Integer> curr = q.poll();

            if (curr == null) {
                if (!q.isEmpty()) {
                    TreeNode<Integer> nextLevelFirstNode = q.peek();
                    leftView.add(nextLevelFirstNode.data);
                    q.offer(null);
                }
            } else {
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }

        for (int val : leftView) {
            System.out.print(val + " ");
        }
    }
}
