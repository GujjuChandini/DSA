class Solution {
    int[][][] dp;
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1][2];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return Math.max(
            helper(nums, 0, -1, 0, n),
            helper(nums, 0, -1, 1, n)
        );
    }
    
    public int helper(int[] nums, int i, int prev, int isUp, int n) {
        if (i == n) return 0;
        
        if (dp[i][prev+1][isUp] != -1) return dp[i][prev+1][isUp];
        
        int take = 0, skip = 0;
        
        if (prev == -1) {
            take = 1 + helper(nums, i+1, i, isUp, n);
        } else {
            if (isUp == 1 && nums[i] > nums[prev]) {
                take = 1 + helper(nums, i+1, i, 0, n);
            } else if (isUp == 0 && nums[i] < nums[prev]) {
                take = 1 + helper(nums, i+1, i, 1, n);
            }
        }
        
        skip = helper(nums, i+1, prev, isUp, n);
        
        return dp[i][prev+1][isUp] = Math.max(take, skip);
    }
}
