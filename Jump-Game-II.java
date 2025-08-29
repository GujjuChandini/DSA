import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n, dp, 0);
    }

    public int helper(int[] nums, int n, int[] dp, int i) {
        if (i == n - 1) {
            return 0; // reached end
        }
        if (dp[i] != -1) {
            return dp[i]; // return memoized result
        }

        int maxJump = nums[i];
        int minJumps = Integer.MAX_VALUE;

        // Try all possible jumps
        for (int j = 1; j <= maxJump && i + j < n; j++) {
            int jumps = helper(nums, n, dp, i + j);
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jumps);
            }
        }

        dp[i] = minJumps;
        return dp[i];
    }
}
