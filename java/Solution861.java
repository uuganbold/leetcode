class Solution861 {
    /*
     * T: O(M*N) S: O(1)
     */
    public int matrixScore(int[][] A) {
        /*
         * [ [1,1,1,1], [1,0,0,1], [1,1,1,1] ] m*n 1. make most leftward column all ones
         * by flipping rows. -> M*N 2. from the second column until end of the
         * matrix->m*n count ones and zeros on the column if ones is greater then go to
         * nex column if zero is greater I will flip that column to make ones are
         * greator
         * 
         * T: O(M*N) S: O(1)
         */

        int ans = 0;
        int M = A.length;
        int N = A[0].length;

        for (int i = 0; i < M; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        ans = M;
        for (int j = 1; j < N; j++) {
            int ones = 0;
            for (int i = 0; i < M; i++) {
                ones += A[i][j];
            }
            if (ones * 2 < M) {
                ones = M - ones;
            }
            ans = ans * 2 + ones;
        }

        return ans;

    }
}