class Solution326 {
    
    /*
        T: O(logN)
        S: O(logN)
    */
    public boolean isPowerOfThree(int n){
        String base=Integer.toString(n,3);
        return base.matches("^10*$");
    }
    
    /*
        T: O(logN)
        S: O(1)
    */
    public boolean isPowerOfThreeLoop(int n) {
        if(n<=0){
            return false;
        }
        
        while(n%3==0){
            n/=3;
        }
        
        return n==1;
    }
    
    
}