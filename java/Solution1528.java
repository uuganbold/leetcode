class Solution1528 {
    /*
     * T: O(N) S: O(N)
     */
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        char[] str = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            ans[indices[i]] = str[i];
        }

        return String.valueOf(ans);
    }
}