class Solution1332 {

    /*
        T: O(N)
        S: O(1)
    */
    public int removePalindromeSub(String s) {
         if(s==null||s.length()==0) return 0;
         if(isPalindrome(s)){
             return 1;
         }
        return 2;
    }
    
    public boolean isPalindrome(String s){
        int lo=0;
        int hi=s.length()-1;
        while(lo<hi){
            if(s.charAt(lo)!=s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}