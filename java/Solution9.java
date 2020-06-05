class Solution9 {

    /*
        T: O(log10_n);
        S: O(1)
    */
    public boolean isPalindromeStupid(int x) {
        if(x<0) return false;
        int tens=1;
        
        while(tens<1000000000&&tens*10<x){
            tens*=10;
        }
        
        while(x>0){
            int first=x/tens;
            int last=x%10;
            if(first!=last) return false;
            
            x=(x%tens)/10;
            tens=tens/100;
        }
        
        return true;
    }
    
        /*
        T: O(log10_n);
        S: O(1)
    */
    public boolean isPalindrome(int x){
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int reverted=0;
        
        while(reverted<x){
            int digit=x%10;
            reverted=reverted*10+digit;
            x/=10;
        }
        
        return reverted==x||reverted/10==x;
        
        
    }
}