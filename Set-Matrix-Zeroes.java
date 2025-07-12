public class Pair {
    int r;
    int c;
    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Pair(i, j));
                }
            }
        }
        for (Pair p : list) {
            int r = p.r;
            int c = p.c;
            for (int j = 0; j < m; j++) {
                matrix[r][j] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
