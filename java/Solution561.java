import java.util.*;
public class Solution561 {
    /**
     * T: O(nlogn)
     * S: O(1)
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i+=2){
            count+=nums[i];
        }
        return count;
    }
}