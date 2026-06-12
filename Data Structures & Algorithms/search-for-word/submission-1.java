class Solution {
    private boolean findWord(
        char[][] board, String word,
        int idx, int i, int j, 
        boolean vis[][],
        int[] dx, int[] dy
    ) {
        if (idx >= word.length()) return true;
        else if (board[i][j] != word.charAt(idx)) return false;

        int m = board.length;
        int n = board[0].length;

        vis[i][j] = true;

        for (int iter = 0; iter < dx.length; iter++){
            int nx = i + dx[iter];
            int ny = j + dy[iter];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                boolean res = findWord(board, word, idx+1, nx, ny, vis, dx, dy);
                if (res) return true;
            }
        }
        vis[i][j] = false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;

        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isFound = findWord(board, word, 0, i, j, vis, dx, dy);
                if (isFound) return true;
            }
        }
        return false;
    }
}
