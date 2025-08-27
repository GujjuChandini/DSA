class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        return Math.max(helper(nums, dp, 0, n-1),helper(nums, dp1, 1, n));
    }
    public int helper(int[] nums, int[] dp, int i, int n){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i]+helper(nums, dp, i+2, n);
        int nottake = helper(nums, dp, i+1, n);
        return dp[i]=Math.max(take, nottake);
    }
}