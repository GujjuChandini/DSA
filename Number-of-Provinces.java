class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(isConnected, vis, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int[] vis, int node) {
        vis[node] = 1;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && vis[j] == 0) {
                dfs(isConnected, vis, j);
            }
        }
    }
}
