class Solution724 {

    /*
        T: O(N)
        S: O(1)
    */
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        
        int left=0;
        for(int i=0;i<nums.length;i++){
            int right=sum-nums[i]-left;
            if(left==right){
                return i;
            }
            left+=nums[i];
        }
        
        return -1;
    }
}