import java.util.*;
class Solution219 {

    /*
        T:O(N)
        S:O(N)
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&map.get(nums[i])+k>=i){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}