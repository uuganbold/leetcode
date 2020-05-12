import java.util.Arrays;

class Solution1160 {

    /*
        T: O(C) - number of characters
        S: O(1)
    */
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        int ans = 0;
        for(char ch : chars.toCharArray()) count[ch - 'a']++;
        for(String word : words){
            int[] tmp = Arrays.copyOf(count, 26);
            boolean isGood = true;
            for(char ch : word.toCharArray()){
                if(tmp[ch - 'a'] == 0){
                    isGood = false;
                    break;
                }else tmp[ch - 'a']--;
            }
            if(isGood) ans += word.length();
        }
        return ans;
    }
}