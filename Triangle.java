class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // int n = triangle.size();
        // int[][] dp = new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return helper(triangle, n, dp, 0, 0);
        return helper1(triangle);
    }
    public int helper(List<List<Integer>> triangle, int n,int[][] dp, int i, int j){
        if(i==n-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = triangle.get(i).get(j)+Math.min(helper(triangle, n, dp, i+1, j),helper(triangle, n, dp, i+1, j+1));
        return dp[i][j]; 
    }
    public int helper1(List<List<Integer>> triangle){
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) +
                           Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}