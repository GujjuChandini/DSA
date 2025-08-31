class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m, n, dp, 0, 0);
    }
    public int helper(int m , int n, int[][] dp, int i, int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if (i >= m || j >= n) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = helper(m, n, dp, i+1, j)+helper(m, n, dp, i, j+1);
        return dp[i][j];
    }
}