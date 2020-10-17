class Solution442 {

    /*
        T: O(N)
        S: O(1)
    */
    public List<Integer> findDuplicates(int[] nums) {
        /*
        
        [-4,-3,-2,-7,8,2,-3,-1]
        [2,3]
        
        
        
        */
        
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i]);
            if(nums[val-1]<0){
                ans.add(val);
            }else{
                nums[val-1]*=-1;
            }    
        }
        
        return ans;
    }
}