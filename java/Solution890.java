import java.util.*;

class Solution890 {

    /*
     * T: O(N) S: O(1)
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private boolean matches(String words, String pattern) {
        if (words.length() != pattern.length()) {
            return false;
        }

        int[] mapWord2Pattern = new int[26];
        int[] mapPattern2Word = new int[26];

        for (int i = 0; i < words.length(); i++) {
            int w = words.charAt(i) - 'a';
            int p = pattern.charAt(i) - 'a';
            if (mapWord2Pattern[w] == 0 && mapPattern2Word[p] == 0) {
                mapWord2Pattern[w] = p + 1;
                mapPattern2Word[p] = w + 1;
            } else if (mapWord2Pattern[w] != p + 1 || mapPattern2Word[p] != w + 1) {
                return false;
            }
        }

        return true;
    }
}