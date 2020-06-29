class Solution1079 {

    /*
        T: O(N!)
        S: O(26)
    */
    public int numTilePossibilities(String tiles) {
         int[] counts=new int[26];
         for(char ch:tiles.toCharArray()){
             counts[ch-'A']++;
         }
        return helper(counts)-1;
    }
    
    private int helper(int[] charSet){
        
        int count=1;
        for(int i=0;i<charSet.length;i++){
            if(charSet[i]>0){
                charSet[i]--;
                count+=helper(charSet);
                charSet[i]++;
            }
        }
        return count;
        
    }
}