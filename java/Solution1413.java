class Solution1413 {

    /*
        T: O(N)
        S: O(1)
    */
    public int minStartValue(int[] nums) {
        int current=nums[0];
        int min=current;
        
        for(int i=1;i<nums.length;i++){
            current+=nums[i];
            if(current<min) min=current;
        }
        
        return 1-min>0?1-min:1;
    }
}