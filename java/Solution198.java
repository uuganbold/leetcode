class Solution198 {

    /*
        T: O(N)
        S: O(N)
    */
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+3];
        dp[0]=0;
        dp[1]=0;
        dp[2]=0;
        
        for(int i=0;i<nums.length;i++){
            dp[i+3]=Math.max(dp[i],dp[i+1])+nums[i];
        }
        
        return Math.max(dp[dp.length-2],dp[dp.length-1]); 
        
    }
}