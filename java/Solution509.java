class Solution509 {
    Integer[] cache;
    
    /*
        T: O(N)
        S: O(N)
    */
    public int fibMemoization(int N) {
        if(N<2) return N;
        
        if(cache==null){
            cache=new Integer[N+1];
        } 
        
        if(cache[N]!=null) return cache[N];
        
        cache[N]=fib(N-1)+fib(N-2);
        return cache[N];
    }
    
    /*
        T: O(N)
        S: O(1)
    */
    public int fib(int N){
        if(N<2) return N;
        if(N==2) return 1;
        
        int current=0;
        int prev1=1;
        int prev2=1;
        
        for(int i=3; i<=N; i++){
            current=prev1+prev2;
            prev2=prev1;
            prev1=current;
        }
        
        return current;
    }
}