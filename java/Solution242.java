import java.util.*;
class Solution242 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean isAnagramEnglishLetters(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] chars=new int[26];
        for(char ch:s.toCharArray()){
            chars[ch-'a']++;
        }
        
        for(char ch:t.toCharArray()){
            if(chars[ch-'a']==0) return false;
            chars[ch-'a']--;
        }
        
        return true;
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public boolean isAnagramHashMap(String s, String t){
        if(s.length()!=t.length()) return false;
        
        Map<Character,Integer> chars=new HashMap<>();
        for(char ch:s.toCharArray()){
            chars.put(ch,chars.getOrDefault(ch,0)+1);
        }
        
        for(char ch:t.toCharArray()){
            Integer count=chars.get(ch);
            if(count==null||count==0) return false;
            chars.put(ch,count-1);
        }
        
        return true;
    }
    
    /*
        T: O(NlogN)
        S: O(1)
    */
    public boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false;
        
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        for(int i=0;i<sChars.length;i++){
            if(sChars[i]!=tChars[i]) return false;
        }
        
        return true;
    }
}