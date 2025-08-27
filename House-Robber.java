class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp, n);
    }
    public int helper(int[] nums, int i, int[] dp, int n){
        if(i>=n) return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i]+helper(nums, i+2, dp, n);
        int nottake = helper(nums, i+1, dp, n);
        return dp[i] = Math.max(take, nottake);
    }
}