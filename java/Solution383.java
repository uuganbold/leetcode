class Solution383 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars=new int[26];
        
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);
            chars[ch-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(chars[ch-'a']==0) return false;
            chars[ch-'a']--;
        }
        
        return true;
    }
}