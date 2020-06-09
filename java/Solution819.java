import java.util.*;

class Solution819 {

    /*
        T: O(P+B)
        S: O(2*P+B)
    */
    public String mostCommonWordSplit(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = Set.of(banned);
        String[] words = paragraph.split("\\W");

        for (String word : words) {
            word = word.toLowerCase();
            if (word.isEmpty() || bannedSet.contains(word))
                continue;

            int previous = map.getOrDefault(word, 0);
            map.put(word, previous + 1);
        }

        return map.entrySet().stream().max(Comparator.comparing(Map.Entry<String, Integer>::getValue))
                .orElseThrow(IllegalArgumentException::new).getKey();
    }

    /*
     * T: O(P+B) S: O(P+B)
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();

        String ans = null;
        int max = 0;

        paragraph += ".";

        StringBuilder word = new StringBuilder();
        for (char ch : paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                word.append(Character.toLowerCase(ch));
            } else {
                if (word.length() > 0) {
                    String wordToAdd = word.toString();
                    if (!bannedSet.contains(wordToAdd)) {
                        wordCount.put(wordToAdd, wordCount.getOrDefault(wordToAdd, 0) + 1);
                        if (wordCount.get(wordToAdd) > max) {
                            ans = wordToAdd;
                            max = wordCount.get(wordToAdd);
                        }
                    }
                    word = new StringBuilder();
                }
            }
        }

        return ans;

    }
}