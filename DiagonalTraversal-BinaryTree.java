/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left = null;
 *      right = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] solve(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        helper(A, 0);

        for (int i = 0; i < map.size(); i++) {
            list.addAll(map.get(i));
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void helper(TreeNode root, int diagonal) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(diagonal)) {
            map.put(diagonal, new ArrayList<Integer>());
        }

        map.get(diagonal).add(root.val);
        
        helper(root.left, diagonal + 1);
        helper(root.right, diagonal);
    }
}
