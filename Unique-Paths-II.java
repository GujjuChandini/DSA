class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        return helper(obstacleGrid, n, m, 0, 0, dp);
    }

    public int helper(int[][] arr, int n, int m, int i, int j, int[][] dp){
        if(i >= n || j >= m) return 0;

        if(arr[i][j] == 1) return 0;

        if(i == n-1 && j == m-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = helper(arr, n, m, i+1, j, dp) + helper(arr, n, m, i, j+1, dp);
        return dp[i][j];
    }
}
