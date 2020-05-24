import java.util.*;
class Solution448 {

    /*
        T: O(N)
        S: O(1)
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0) nums[idx]=-1*nums[idx];
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) ans.add(i+1);
        }
        
        return ans;        
                
    }
}