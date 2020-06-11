class Solution747 {

    /*
        T: O(N)
        S: O(1)
    */
    public int dominantIndex(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        
        int index=0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=max&&nums[i]!=0){
                if(max/nums[i]<2){
                    return -1;
                }
            }
        }
        
        return index;
    }
}