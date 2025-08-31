class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // int n = matrix.length;
        // int m = matrix[0].length;
        // int[][] dp = new int[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // int min = Integer.MAX_VALUE;
        // for (int j = 0; j < m; j++) {
        //     min = Math.min(min, helper(matrix, n, m, dp, 0, j));
        // }
        // return min;
        return helper1(matrix);
    }

    public int helper(int[][] matrix, int n, int m, int[][] dp, int i, int j) {
        if (j < 0 || j >= m) {
            return (int) 1e9; 
        }
        if (i == n - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = helper(matrix, n, m, dp, i + 1, j);
        int left = helper(matrix, n, m, dp, i + 1, j - 1);
        int right = helper(matrix, n, m, dp, i + 1, j + 1);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
    }
    public int helper1(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<m;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int curr = dp[i+1][j];
                int curr1 = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int curr2 = (j < m - 1) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j]+Math.min(curr, Math.min(curr1, curr2));
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minPath = Math.min(minPath, dp[0][j]);
        }

        return minPath;
    }
}
