class Solution {
    private int findWays(int m, int n, int i, int j, int[][] dp, int[][] dir) {
        if (i == m-1 && j == n-1) return 1;

        if (dp[i][j] != -1) return dp[i][j];
        int ways = 0;
        for (int[] d: dir) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                ways += findWays(m, n, nx, ny, dp, dir);
            }
        }
        return dp[i][j] = ways;
    }
    public int uniquePaths(int m, int n) {
        if (m==1 || n==1) return 1;

        int dp[][] = new int[m][n];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }
        int dir[][] = new int[][]{
            {0, 1},
            {1, 0}
        };
        return findWays(m, n, 0, 0, dp, dir);
    }
}
