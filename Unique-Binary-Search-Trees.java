class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }

    public int helper(int[] dp, int n) {
        if (n<=1){
            return 1;
        }

        if (dp[n]!=-1){
            return dp[n];
        }
        int total=0;
        for (int i=1;i<=n;i++) {
            int left = helper(dp, i-1);
            int right = helper(dp, n-i);
            total+=left*right;
        }
        dp[n] = total;
        return total;
    }
}