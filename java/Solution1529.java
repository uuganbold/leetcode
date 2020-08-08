class Solution1529 {

    /*
     * T: O(N) S: O(1)
     */
    public int minFlips(String target) {
        char bit = '0';
        int ans = 0;
        for (char ch : target.toCharArray()) {
            if (ch != bit) {
                bit = ch;
                ans++;
            }
        }

        return ans;
        /*
         * 00000 -> 10111 zero:false count:3
         * 
         * 
         * 000000000->001011101 zero:false count:5
         * 
         * 001011101
         */
    }
}