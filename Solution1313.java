class Solution1313 {
    /*
    T: O(n)
    S: O(1)
    */
    
    public int[] decompressRLElist(int[] nums) {
        int length=0;
        for(int i=0;i<nums.length;i+=2){
            length+=nums[i];
        }
        
        int[] result=new int[length];
        
        int cursor=0;
        for(int i=0;i<nums.length;i+=2){
            for(int j=cursor;j<cursor+nums[i];j++){
                result[j]=nums[i+1];
            }
            cursor+=nums[i];
        }
        
        return result;
    }
}