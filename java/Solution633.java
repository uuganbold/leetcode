class Solution633 {

    /*
        T: O(sqrt(c)*logc)
        S: O(1)
    */
    public boolean judgeSquareSumBS(int c){
        for(int i=0;i*i<=c;i++){
             int j=c-i*i;
             if(bs(j)){
                 return true;
             }
            
            if(j<i){
                break;
            }
         }
        
        return false;
    }
    
    private boolean bs(int j){
        long lo=0;
        long hi=j;
        
        while(lo<=hi){
            long mi=lo+(hi-lo)/2;
            
            if(mi*mi==j){
                return true;
            }
            
            if(mi*mi>j){
                hi=mi-1;
            }else{
                lo=mi+1;
            }
            
        }
        
        return false;
    }
    
    
    /*
        T: O(sqrt(c)*logc)
        S: O(1)
    */
    public boolean judgeSquareSum(int c) {
        
         for(int i=0;i*i<=c;i++){
             double j=Math.sqrt(c-i*i);
             if(j==(int)j){
                 return true;
             }
             if(j<i){
                 break;
             }
         }
        
        return false;
    }
    
}