import java.util.*;
class Solution628 {

    /*
        T: O(NlogN)
        S: O(1)
    */
    public int maximumProductSort(int[] nums) {
        Arrays.sort(nums);
        
        int N=nums.length;
        int max=nums[N-3]*nums[N-2]*nums[N-1];
        return Math.max(max, nums[0]*nums[1]*nums[N-1]); 
    }
    
    /*
        T: O(N)
        S: O(1)
    */
    public int maximumProduct(int[] nums){
        int max1=Integer.MIN_VALUE;
        int max2=max1, max3=max1;
        int min1=Integer.MAX_VALUE;
        int min2=min1;
        
        for(int n:nums){
            if(n>=max1){
                max3=max2;
                max2=max1;
                max1=n;
            }else if(n>=max2){
                max3=max2;
                max2=n;
            }else if(n>=max3){
                max3=n;
            }
            
            if(n<=min1){
                min2=min1;
                min1=n;
            }else if(n<=min2){
                min2=n;
            }
        }
        
        return Math.max(max1*max2*max3,max1*min1*min2);
        
    }
}