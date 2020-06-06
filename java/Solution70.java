class Solution70 {

    /*
        T: O(n)
        S: O(1)
    */
    public int climbStairs(int n) {
        
        int prev1=1;
        int prev2=1;
        
        for(int k=2;k<=n;k++){
            int temp=prev1+prev2;
            prev1=prev2;
            prev2=temp;
        }
        
        return prev2;
        
    }
}