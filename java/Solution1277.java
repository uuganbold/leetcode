class Solution1277 {
    /*
     * T: O(n*m) S: O(1)
     */
    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i != 0 && j != 0) {
                        int min = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                        min = Math.min(min, matrix[i][j - 1]);
                        matrix[i][j] = min + 1;
                    }
                    count += matrix[i][j];
                }

            }
        }

        return count;
    }

    /*
     * [ [0,1,0,1,1] [0,1,1,1,0], [1,1,1,1,1], [0,1,1,1,1] ]
     * 
     * [0,0,0,0,0,0] [0,0,1,0,1,1] [0,0,1,1,1,0], [0,1,1,2,2,1], [0,0,1,2,3,2] ]
     * 
     */
}