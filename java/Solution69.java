class Solution69 {

    /*
    
        T: O:(logX)
        S: O(1)
    */
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        long lo=0;
        long hi=x;
        while(lo<hi){
            long mi=lo+(hi-lo)/2;
            if(mi*mi==x){
                return (int)mi;
            }else if(mi*mi<x){
                lo=mi+1;
            }else{
                hi=mi;
            }
        }
        return (int)(lo-1);
    }
}