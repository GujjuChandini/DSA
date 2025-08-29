class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean left = true;
        boolean right = true;

        if (root.left != null) {
            left = (root.left.val < root.val) && validate(root.left, min, root.val);
        }
        if (root.right != null) {
            right = (root.right.val > root.val) && validate(root.right, root.val, max);
        }

        return left && right;
    }
}
