class Solution35 {
    /*
        T: O(logN)
        S: O(1)
    */
    public int searchInsert(int[] nums, int target) {
        
        int lo=0;
        int hi=nums.length;
        
        while(lo<hi){
            int mi=lo+(hi-lo)/2;
            
            if(nums[mi]<target){
                lo=mi+1;
            }else{
                hi=mi;
            }
        }
        
        return lo;
    }
}