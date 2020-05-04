import java.util.*;
class Solution1403 {

    /**
     * T: O(nlogn)
     * S: O(1)
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result=new ArrayList<>();
        
        Arrays.sort(nums);
        int sum=Arrays.stream(nums).sum();
        
        int subSum=0;
        int i=nums.length;
        while(subSum<=sum-subSum){
            i--;
            result.add(nums[i]);
            subSum+=nums[i];
        }
        return result;
    }
}