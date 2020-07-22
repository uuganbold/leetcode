class Solution1518 {

    /*
     * T: O(logN) S: O(1)
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        while (numBottles > 0) {
            ans += numBottles;
            int total = numBottles + empty;
            numBottles = total / numExchange;
            empty = total % numExchange;
        }
        return ans;
    }
}