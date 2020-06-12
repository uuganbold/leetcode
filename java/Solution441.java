class Solution441 {
    
    /*
        T: O(logN)
        S: O(1)
    */
    public int arrangeCoins(int n){
        long lo=0;
        long hi=n;
        
        while(lo<=hi){
            long mi=lo+(hi-lo)/2;
            
            long total=mi*(mi+1)/2;
            
            if(total==n){
                return (int)mi;
            }
            
            if(total<n){
                lo=mi+1;
            }else{
                hi=mi-1;
            }  
        }
        
        return (int)hi;
    }
  
    /*
        T: O(1)
        S: O(1)
    */
    public int arrangeCoinsMath(int n) {
        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
    }
}