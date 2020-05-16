class Solution762 {
    /*
        T: O(N)
        S: O(1)
    */
    public int countPrimeSetBits(int L, int R) {
        int count=0;
         for(int n=L;n<=R;n++){
             if(isSmallPrime(Integer.bitCount(n))) count++;
         }
        return count;
    }
    
    private int countOfBits(int n){
        //Integer.bitCount(n);
        int count=0;
        while(n>0){
            count+=n&1;
            n=n>>1;
        }
        return count;
    }
    
    private boolean isSmallPrime(int n){
        return (n==2||n==3||n==5||n==7||n==11||n==13||n==17||n==19||n==23||n==29||n==31);
    }
    
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}