class Solution1539 {

    /*
     * T: O(N) S: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        /*
         * [2,3,4,7] 1+0+0+2=3
         * 
         * 7-(1+1)=9;
         */
        int prev = 0;
        int missing = 0;
        int i = 0;
        while (i < arr.length && missing < k) {
            missing += arr[i] - prev - 1;
            prev = arr[i];
            i++;
        }

        int ans;
        if (missing >= k) {
            ans = prev - 1 - (missing - k);
        } else {
            ans = prev + (k - missing);
        }

        return ans;
    }
}