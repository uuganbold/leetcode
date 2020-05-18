class Solution1189 {

    /*
        T: O(N)
        S: O(26)
    */
    public int maxNumberOfBalloons(String text) {
        int count=Integer.MAX_VALUE;
        int[] chars=new int[26];
        
        for(char ch:text.toCharArray()){
            chars[ch-'a']++;
        }
        
        int[] word=new int[26];
        for(char ch:"balloon".toCharArray()){
            word[ch-'a']++;
        }
        
        for(int i=0;i<chars.length;i++){
            if(word[i]!=0){
                count=Math.min(count,chars[i]/word[i]);
            }
        }
        
        return count;
    }
}