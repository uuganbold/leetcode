class Solution1523 {
    /*
     * T: O(1) S: O(1)
     */
    public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}