class Solution27 {

    /*
        T: O(n)
        S: O(1)
    */
    public int removeElement(int[] nums, int val) {
        int end=nums.length-1;
        for(int i=0;i<=end;i++){
            if(nums[i]==val){
                nums[i]=nums[end];
                end--;
                i--;
            }
        }
        return end+1;
    }
    
}