class Solution665 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean checkPossibility(int[] nums) {
        int idx=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(idx>=0){
                    return false;
                }
                idx=i;
            }
        }
        
        return  idx==-1||
                idx==0||
                idx==nums.length-2||
                nums[idx-1]<=nums[idx+1]||
                nums[idx]<=nums[idx+2];
    }
}