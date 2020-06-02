class Solution746 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public int minCostClimbingStairs(int[] cost) {
        int[] branches=new int[]{cost[cost.length-1],cost[cost.length-2]};
        int i=0;
        
        for(int j=cost.length-3;j>=0;j--){
            int minCost=Math.min(branches[0],branches[1])+cost[j];
            branches[i]=minCost;
            i^=1;         
        }
        
        return Math.min(branches[0],branches[1]);
        
    }
    
}