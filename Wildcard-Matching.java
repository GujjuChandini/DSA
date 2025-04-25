class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return helper(s, p, dp, 0, 0, n, m);
    }

    private boolean helper(String s, String p, Boolean[][] dp, int i, int j, int n, int m) {
        if (i == n && j == m) return true;
        if (j == m) return false;

        if (dp[i][j] != null) return dp[i][j];

        boolean match = false;

        if (j < m && p.charAt(j) == '*') {
            match = (i < n && helper(s, p, dp, i + 1, j, n, m)) || helper(s, p, dp, i, j + 1, n, m);
        } else if (i < n && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
            match = helper(s, p, dp, i + 1, j + 1, n, m);
        }

        return dp[i][j] = match;
    }
}
