class Solution680 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean validPalindrome(String s) {
         return validPalindrome(s, 0,s.length()-1,1);
    }
    
    /*
        T:O(N)
        S:O(allowedFix)
    */
    private boolean validPalindrome(String s, int left, int right, int allowedFix){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(allowedFix==0){
                    return false;
                }else{
                    return (validPalindrome(s, left+1,right,allowedFix-1)||
                        validPalindrome(s, left,right-1,allowedFix-1));
                }
            }
            left++;
            right--;
        }
        
        return true;
    }
}