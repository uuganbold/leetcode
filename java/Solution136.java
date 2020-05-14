class Solution136 {

    /*
        T: O(N)
        S: O(1)
    */
    public int singleNumber(int[] nums) {
        int result=0;
        for(int n:nums){
            result^=n;
        }
        
        return result;
        
    }
}