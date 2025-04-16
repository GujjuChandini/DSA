// InterviewBit

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
import java.util.*;

public class Solution {
    public int t2Sum(TreeNode A, int B) {
        List<Integer> inorderList = new ArrayList<>();
        inOrder(A, inorderList);

        int left = 0;
        int right = inorderList.size() - 1;

        while (left < right) {
            int sum = inorderList.get(left) + inorderList.get(right);
            if (sum == B) return 1;
            else if (sum < B) left++;
            else right--;
        }

        return 0;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
