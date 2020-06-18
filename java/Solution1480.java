class Solution1480 {

    /*
        T: O(N)
        S: O(1)
    */
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        
        return nums;
    }
}