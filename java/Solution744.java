class Solution744 {
    /**
     * 
     * T: O(LogN)
     * S: O(1)
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int lo=0;
        int hi=letters.length;
        
        while(lo<hi){
            int mi=(lo+hi)/2;
            
            if(letters[mi]<=target){
                lo=mi+1;
            }else{
                hi=mi;
            }
        }
        if(lo>=letters.length){
            return letters[0];
        }else{
            return letters[lo];
        }
    }
}