class Solution1551 {

    /*
     * T: O(1) S: O(0)
     */
    public int minOperations(int n) {
        int ans = 0;
        if (n % 2 == 0) {
            ans = n * n / 4;
        } else {
            ans = (n - 1) * (n + 1) / 4;
        }

        return ans;
        /*
         * 1,3,5,7,9,11
         * 
         * 5,3,1,1,3,5
         */
    }
}