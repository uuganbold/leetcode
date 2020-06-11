class Solution367 {

    /*
        T: O(logN)
        S: O(1)
    */
    public boolean isPerfectSquare(int num) {
        if(num<0){
            return false;
        }
        
        if(num<2){
            return true;
        }
        
        int lo=0;
        int hi=num;
        
        while(lo<hi){
            int mi=lo+(hi-lo)/2;
            
            if(mi<num/mi){
                lo=mi+1;
            }else{
                hi=mi;
            }
        }
        return lo*lo==num;
    }
}