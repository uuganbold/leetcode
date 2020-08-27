class Solution1550 {

    /*
     * T: O(N) S: O(1)
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }
}