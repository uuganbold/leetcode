class Solution1137 {

    /*
        T: O(N)
        S: O(1)
    */
    public int tribonacci(int n) {
        if(n<0) throw new IllegalArgumentException("n cannot be less than 0");
        if(n==0) return 0;
        if(n<=2) return 1;
        
        int prev3=0;
        int prev2=1;
        int prev1=1;
        
        for(int i=3;i<=n;i++){
            int temp=prev3+prev2+prev1;
            prev3=prev2;
            prev2=prev1;
            prev1=temp;
        }
        
        return prev1;
    }
}