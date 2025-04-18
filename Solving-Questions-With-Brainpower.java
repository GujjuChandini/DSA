class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        Long[] dp = new Long[n];
        return helper(0, questions, dp, n);
    }

    public long helper(int index, int[][] arr, Long[] dp, int n){
        if(index >= n){
            return 0;
        }

        if(dp[index] != null){
            return dp[index];
        }

        long take = arr[index][0];
        int skipUpto = index + arr[index][1] + 1;
        take += helper(skipUpto, arr, dp, n);

        long skip = helper(index + 1, arr, dp, n);

        dp[index] = Math.max(take, skip);
        return dp[index];
    }
}
