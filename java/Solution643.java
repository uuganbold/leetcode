class Solution643 {

    /*
        T: O(N)
        S: O(1)
    */
    public double findMaxAverage(int[] nums, int k) {
        
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        
        int max=sum;
        for(int i=1;i+k-1<nums.length;i++){
            sum=sum+nums[i+k-1]-nums[i-1];
            if(sum>max){
                max=sum;
            }
        }
        return (double)max/k;
        
    }
}