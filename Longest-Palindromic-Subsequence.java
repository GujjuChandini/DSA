class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        return helper(s, sb.reverse().toString(), 0, 0, n, dp);
    }
    public int helper(String s1, String s2, int i, int j, int n, int[][] dp){
        if(i>=n || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+helper(s1, s2, i+1, j+1, n, dp);
        }else{
            dp[i][j] = Math.max(helper(s1, s2, i+1, j, n, dp), helper(s1, s2, i, j+1, n, dp));
        }
        return dp[i][j];
    }
}