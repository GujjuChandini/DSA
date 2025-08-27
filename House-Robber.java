class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return helper(nums, 0, dp, n);
        return helper1(nums);
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
    public int helper1(int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public int helper2(int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int curr = Math.max(nums[i]+prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}