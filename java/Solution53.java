class Solution53 {
    
    public int maxSubArray(int[] nums){
        return maxSubArrayRecursive(nums,0,nums.length);
    }
    
    /*
        T: O(N)
        S: O(1)
    */
    public int maxSubArraySimple(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    
    
    /*
        T: O(NlogN)
        S: O(1)
    */
    public int maxSubArrayRecursive(int[] nums, int lo, int hi){
        if(lo+1>=hi){
            return nums[lo];
        }

        int mi=(lo+hi)/2;
        int max=crossingMax(nums,lo,hi,mi);

        max=Math.max(max,maxSubArrayRecursive(nums,lo,mi));
        max=Math.max(max,maxSubArrayRecursive(nums,mi,hi));
        
        return max;
        
    }
    
    public int crossingMax(int[] nums, int lo, int hi, int mi){
        int leftMax=nums[mi-1];
        int sum=0;
        for(int i=mi-1;i>=lo;i--){
            sum+=nums[i];
            if(sum>leftMax){
                leftMax=sum;
            }
        }
        
        int rightMax=nums[mi];
        sum=0;
        for(int i=mi;i<hi;i++){
            sum+=nums[i];
            if(sum>rightMax){
                rightMax=sum;
            }
        }
        
        return leftMax+rightMax;
        
    }
}