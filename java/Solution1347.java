class Solution1347 {

    /*
        T: O(N)
        S: O(26)
    */
    public int minSteps(String s, String t) {
        int[] counts=new int[26];
        for(char ch:s.toCharArray()){
            counts[ch-'a']++;
        }
 
        int diff=0;
        for(char ch:t.toCharArray()){
            counts[ch-'a']--;
        }
        
  
        
        for(int i=0;i<counts.length;i++){
            diff+=Math.abs(counts[i]);
        }
        
        return diff/2;
    }
}