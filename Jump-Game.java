class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return helper(nums, n, dp, 0);
    }
    public boolean helper(int[] nums, int n, Boolean[] dp, int i){
        if(i==n-1){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int jumps = nums[i];
        for(int j=1;j<=jumps && i+j<n;j++){
            if(helper(nums, n, dp, i+j)){
                dp[i]=true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
}