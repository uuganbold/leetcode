import java.util.*;
class Solution169 {
    
    /**
     * Really cool algorithm.
     * T: O(N)
     * S: O(1)
     */
    public int majorityElement(int[] nums){
        int count=0;
        int current=nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0){
                current=nums[i];
            }
            count+=current==nums[i]?1:-1;
        }
        return current;
    }
    
    /*
        T: O(NlogN)
        S: O(1) - java uses quicksort for primitive arrays.
    */
    public int majorityElementStupid(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length/2;
        for(int i=0;i<nums.length-length;i++){
            if(nums[i]==nums[i+length]) return nums[i];
        }
        
        return -1;
    }
}