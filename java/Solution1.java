import java.util.*;
class Solution1 {

    /*
        T: O(N)
        S: O(N)
    */
    public int[] twoSum(int[] nums, int target) {
        if(nums==null) return null;
        
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            
            map.put(nums[i],i);
        }
        
        return null;
    }
}