class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return helper(s1, s2, s3, n, m, 0, 0, dp);
    }

    private boolean helper(String s1, String s2, String s3, int n, int m, int i, int j, Boolean[][] dp) {
        if (i == n && j == m) return true;
        if (dp[i][j] != null) return dp[i][j];
        int k = i + j;
        boolean canForm = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            canForm = helper(s1, s2, s3, n, m, i + 1, j, dp);
        }
        if (!canForm && j < m && s2.charAt(j) == s3.charAt(k)) {
            canForm = helper(s1, s2, s3, n, m, i, j + 1, dp);
        }
        dp[i][j] = canForm;
        return dp[i][j];
    }
}
