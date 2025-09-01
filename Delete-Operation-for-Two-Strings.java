class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(word1, word2, n, m, dp, 0, 0);
    }
    public int helper(String word1, String word2, int n, int m, int[][] dp, int i, int j){
        if(i==n){
            return m-j;
        }
        if(j==m){
            return n-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j] = helper(word1, word2, n, m, dp, i+1, j+1);
        }else{
            dp[i][j] = 1+Math.min(helper(word1, word2, n, m, dp, i+1, j),helper(word1, word2, n, m, dp, i, j+1));
        }
        return dp[i][j];
    }
}