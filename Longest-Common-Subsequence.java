class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int n1 = text1.length();
        // int n2 = text2.length();
        // int[][] dp = new int[n1][n2];
        // for(int i=0;i<n1;i++){
        //     for(int j=0;j<n2;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return helper(text1, text2, n1, n2, dp, 0, 0);
        return helper2(text1, text2);
    }
    public int helper(String text1, String text2, int n1, int n2, int[][] dp, int i, int j){
        if(i>=n1 || j>=n2){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            take = 1+helper(text1, text2, n1, n2, dp, i+1, j+1);
        }
        int nottake = Math.max(helper(text1, text2, n1, n2, dp, i+1, j), helper(text1, text2, n1, n2, dp, i, j+1));
        return dp[i][j] = Math.max(take, nottake);
    }
    public int helper2(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}