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
import java.util.*;
class Pair {
    TreeNode node;
    int hlevel;
    
    Pair(TreeNode node, int hlevel) {
        this.node = node;
        this.hlevel = hlevel;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: horizontal level → list of values at that level
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new TreeMap<>();

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int level = current.hlevel;

                tempMap.putIfAbsent(level, new ArrayList<>());
                tempMap.get(level).add(node.val);

                if (node.left != null) {
                    queue.offer(new Pair(node.left, level - 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, level + 1));
                }
            }

            // Sort each level before adding to final map (for vertical order requirement)
            for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
                List<Integer> sorted = entry.getValue();
                Collections.sort(sorted);
                map.putIfAbsent(entry.getKey(), new ArrayList<>());
                map.get(entry.getKey()).addAll(sorted);
            }
        }

        // Prepare result
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> values : map.values()) {
            result.add(values);
        }

        return result;
    }
}
