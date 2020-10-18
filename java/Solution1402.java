class Solution1402 {
    
    int[] sortedSatisfaction;
    int N;
    
    Integer[][] dp;
    
    public int maxSatisfaction(int[] A) {
        Arrays.sort(A);
        int res = 0, total = 0, n = A.length;
        for (int i = n - 1; i >= 0 && A[i] > -total; --i) {
            total += A[i];
            res += total;
        }
        return res;
    }
    
    
    public int maxSatisfaction1(int[] satisfaction) {
        /*
        [-1,-8,0,5,-9]
        
        [4,3,2]
        */
        N=satisfaction.length;
        Arrays.sort(satisfaction);
        sortedSatisfaction=satisfaction;
        
        dp=new Integer[N][N];
        
        return helper(0,1);
    }
    
    private int helper(int i, int time){
         if(i>=N){
             return 0;
         }
         if(dp[i][time-1]!=null){
             return dp[i][time-1];
         }
         int max=sortedSatisfaction[i]*time+helper(i+1, time+1);
         max=Math.max(max,helper(i+1,time));
        
         dp[i][time-1]=max;
         return max;
    }
}