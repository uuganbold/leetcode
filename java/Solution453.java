import java.util.*;
class Solution453 {

    /*
        T: O(N)
        S; O(1)
    */
    public int minMoves(int[] nums){
        
        int min=Integer.MAX_VALUE;
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                sum+=i*(min-nums[i]);
                min=nums[i];
            }else{
                sum+=nums[i]-min;
            }
        }
            
        return sum;    
    }
    
    /*
        T: O(N)
        S: O(1)
    */
    public int minMovesSort(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Arrays.sort(nums);
        int sum=0;
        for(int n:nums){
            sum+=n-nums[0];
        }
        return sum;
    }
}