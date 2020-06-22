class Solution204 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public int countPrimes(int n){
        if(n<=2){
            return 0;
        }
        if(n==3){
            return 1;
        }
        boolean[] check=new boolean[n]; 
        int primeCount=0;
        for(int i=2;i<n;i++){
            if(!check[i]){
                primeCount++;
                for(int j=i;j<n;j+=i){
                    check[j]=true;
                }
            }
        }
        
        return primeCount;
    }
    
    
    /*
        T: O(n*sqrt(n))
        S: O(1)
    */
    public int countPrimesSlow(int n) {
        if(n<=2){
            return 0;
        }
        if(n==3){
            return 1;
        }
        
        int count=1;
        for(int i=3;i<n;i+=2){
            if(isPrime(i)){
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int n){
        if(n<2){
            return false;
        }
        if(n==2){
            return true;
        }
        
        if(n%2==0){
            return false;
        }
        
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0){
                return false;
            }
        }
        
        return true;
    }
}