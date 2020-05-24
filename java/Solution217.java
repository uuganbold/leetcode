import java.util.*;
class Solution217 {

    /*
        T: O(NlogN)
        S: O(1)
    */
    public boolean containsDuplicateSort(int[] nums) {
         Arrays.sort(nums);
         for(int i=0;i<nums.length-1;i++){
             if(nums[i]==nums[i+1]) return true;
         }

        return false;
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public boolean containsDuplicateSet(int[] nums){
        Set<Integer> set=new HashSet();
        for(int n:nums) set.add(n);
        return set.size()!=nums.length;
    }
    
    public boolean containsDuplicate(int[] nums){
        Set<Integer> set=new HashSet();
        for(int n:nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        
        return false;
    }
}