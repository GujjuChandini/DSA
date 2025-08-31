class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] =-1;
            }
        }
        return helper(grid, n, m, dp, 0, 0);
    }
    public int helper(int[][] grid, int n, int m, int[][] dp, int i, int j){
        if(i>=n || j>=m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1 && j == m-1) return grid[i][j];
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right = helper(grid, n, m, dp, i, j+1);
        int down = helper(grid, n, m, dp, i+1, j);
        return dp[i][j] = grid[i][j]+Math.min(right, down);
    }
}