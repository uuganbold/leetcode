class Solution921 {

    /*
     * T: O(N) S: O(1)
     */
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int stack = 0;

        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack++;
            } else if (stack == 0) {
                ans++;
            } else {
                stack--;
            }
        }

        ans += stack;

        return ans;
    }
}