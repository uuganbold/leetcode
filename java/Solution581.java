import java.util.*;
class Solution581 {
    
    /*
        T: O(4N)
        S: O(1)
    */
    public int findUnsortedSubarray(int[] nums){
         boolean flag=false;
    
         int min=Integer.MAX_VALUE;
         for(int i=1;i<nums.length;i++){
             if(nums[i]<nums[i-1]){
                 flag=true;
             }
             if(flag){
                 min=Math.min(min,nums[i]);
             }
         }
        
         flag=false;
         int max=Integer.MIN_VALUE;
         for(int i=nums.length-2;i>=0;i--){
              if(nums[i]>nums[i+1]){
                  flag=true;
              }
             
              if(flag){
                  max=Math.max(max,nums[i]);
              }
         }
        
        int l,r;
        for(l=0;l<nums.length;l++){
            if(min<nums[l]){
                break;
            }
        }
        
        for(r=nums.length-1;r>=0;r--){
            if(max>nums[r]){
                break;
            }
        }
        
        return r - l < 0 ? 0 : r - l + 1;
    }
    
    /*
    T: O(n)
    S: O(n)
    */
    public int findUnsortedSubarrayStack(int[] nums){
        int[] stack=new int[nums.length];
        int pointer=0;
        
        int l=nums.length;
        for(int i=0;i<nums.length;i++){
            while(pointer>0&&nums[stack[pointer-1]]>nums[i]){
                l=Math.min(l,stack[pointer-1]);
                pointer--;
            }
            stack[pointer++]=i;
        }

        pointer=0;
        int r=0;
        for(int i=nums.length-1;i>=0;i--){
            while(pointer>0&&nums[stack[pointer-1]]<nums[i]){
                r=Math.max(r,stack[pointer-1]);
                pointer--;
            }
            stack[pointer++]=i;
        }
        
        
        return r - l > 0 ? r - l + 1 : 0;
    }
    
    /*
        T: O(nlogN)
        s: O(n)
    */
    public int findUnsortedSubarraySort(int[] nums) {
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        
        int left=0;
        while(left<nums.length&&nums[left]==sorted[left]){
            left++;
        }
        
        int right=nums.length-1;
        while(right>=left && nums[right]==sorted[right]){
            right--;
        }
        
        return right-left+1;
    }
}