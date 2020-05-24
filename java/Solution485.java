class Solution485 {

    /*
        T: O(n)
        S: O(1)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int max=0;
        int count=0;
        for(int n:nums){
            if(n==0) {
                max=count>max?count:max;
                count=0;
            }else count++;
        }
        
        if(count>max) return count; 
        
        return max;
    }
}