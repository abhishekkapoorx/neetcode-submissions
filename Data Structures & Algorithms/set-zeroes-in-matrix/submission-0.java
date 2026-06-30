class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> places = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    places.add(new int[]{i, j});
                }
            }
        }

        for (int[] place: places) {
            int x = place[0];
            int y = place[1];

            for (int i = 0; i < matrix.length; i++) {
                matrix[x][i] = 0;
                matrix[i][y] = 0;
            }
        }


    }
}
