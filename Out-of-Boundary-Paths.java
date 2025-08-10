class Solution {
    private final int MOD = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(m, n, maxMove, dp, startRow, startColumn, 0);
    }
    
    public int helper(int m, int n, int maxMove, int[][][] dp, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (k == maxMove) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        
        int left = helper(m, n, maxMove, dp, i - 1, j, k + 1);
        int right = helper(m, n, maxMove, dp, i + 1, j, k + 1);
        int up = helper(m, n, maxMove, dp, i, j - 1, k + 1);
        int down = helper(m, n, maxMove, dp, i, j + 1, k + 1);
        
        dp[i][j][k] = ((left + right) % MOD + (up + down) % MOD) % MOD;
        return dp[i][j][k];
    }
}