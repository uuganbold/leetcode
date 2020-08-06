class Solution1534 {
    /*
     * T: O(N^3) S: O(1)
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[k]) <= c && Math.abs(arr[j] - arr[k]) <= b) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}