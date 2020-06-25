class Solution7 {

    /*
        T: O(logX)
        S: O(1)
    */
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int digit=x%10;
            x/=10;
            if(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&digit>7)){
                return 0;
            }
            
            if(ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE&&digit<-8)){
                return 0;
            }
            
            ans=ans*10+digit;
        }
        
        return ans;
        
    }
}