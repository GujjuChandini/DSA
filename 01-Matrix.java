class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] place = q.poll();
            int row = place[0];
            int col = place[1];

            for (int[] d : dir) {
                int ni = row + d[0];
                int nj = col + d[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    res[ni][nj] = res[row][col] + 1;
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return res;
    }
}
