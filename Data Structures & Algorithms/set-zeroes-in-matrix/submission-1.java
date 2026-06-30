class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> places = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Store all zero positions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    places.add(new int[]{i, j});
                }
            }
        }

        // Set corresponding rows and columns to zero
        for (int[] place : places) {
            int x = place[0];
            int y = place[1];

            for (int j = 0; j < cols; j++) {
                matrix[x][j] = 0;
            }

            for (int i = 0; i < rows; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}