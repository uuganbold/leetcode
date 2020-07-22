class Solution1314 {

    /*
     * T: O(M*N) S: O(M*N)
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int M = mat.length;
        int N = mat[0].length;

        int[][] rows = new int[M][N];
        int[][] cols = new int[M][N];

        for (int i = 0; i < M; i++) {
            int rowSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += mat[i][j];
                rows[i][j] = rowSum;
            }
        }

        for (int i = 0; i < N; i++) {
            int colSum = 0;
            for (int j = 0; j < M; j++) {
                colSum += rows[j][i];
                cols[j][i] = colSum;
            }
        }

        int[][] ans = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int highRow = Math.min(i + K, M - 1);
                int highCol = Math.min(j + K, N - 1);
                ans[i][j] = cols[highRow][highCol];
                if (i - K > 0) {
                    ans[i][j] -= cols[i - K - 1][highCol];
                }
                if (j - K > 0) {
                    ans[i][j] -= cols[highRow][j - K - 1];
                }
                if (i > K && j > K) {
                    ans[i][j] += cols[i - K - 1][j - K - 1];
                }
            }
        }

        return ans;

    }

    /*
     * T: O(M*N*K*K) S: O(1)
     */
    public int[][] matrixBlockSumNaive(int[][] mat, int K) {
        /*
         * [1,2,3,5,6,7] [4,5,6,6,4,2] [7,8,9,5,3,2] [5,3,4,6,3,2] [3,4,5,2,3,5]
         * 
         * 
         * 
         * [1,3,6,11,17,24] [4,9,15,21,25,27] [7,15,24,29,32,24] [5,8,12,28,21,23]
         * 
         * 0 0 0 0 0 0. 0 0 [1,3,6,11,17,24] [0:0->0:0][0:0->0:1][0:0->0:2] 0
         * [5,12,21,32,42,51] [0:0->1:0][0:0->1:1][0:0->1:2] 0 [12,27,45,61,74,75] 0
         * [17,35,57,89,95,98]
         */
        int M = mat.length;
        int N = mat[0].length;

        int[][] ans = new int[M][N];

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {

                for (int i = -1 * K; i <= K; i++) {
                    int row = m + i;
                    for (int j = -1 * K; j <= K; j++) {
                        int col = n + j;
                        if (row >= 0 && row < M && col >= 0 && col < N) {
                            ans[m][n] += mat[row][col];
                        }
                    }
                }
            }
        }

        return ans;
    }
}