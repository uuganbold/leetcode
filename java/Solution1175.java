class Solution1175 {

    /*
        T: O(N^1.5)
        S: O(1)
    */
    public int numPrimeArrangements(int n) {
        int numOfPrime=0;
        for(int i=1;i<=n;i++){
            if(isPrime(i)) numOfPrime++;
        }
        
        int ans=factorial(1,numOfPrime,1000000007);
        ans=factorial(ans,n-numOfPrime,1000000007);
        return ans;
        
    }
    
    private int factorial(int initial,int n, int modulo){
        long fact=initial;
        for(int i=1;i<=n;i++){
            fact=(fact*i)%modulo;
        }
        return (int)fact;
    }
    
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
             if(n%i==0) return false;
        }
        return true;
    }
}