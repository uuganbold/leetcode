class Solution283 {

    /*
        T: O(N)
        S: O(1)
    */
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        
        int current=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) nums[current++]=nums[i];
        }
        
        for(int i=current;i<nums.length;i++){
            nums[i]=0;
        }
    }
}