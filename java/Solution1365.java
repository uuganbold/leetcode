class Solution1365 {
    /*
    T: O(n)
    S: O(101)=O(1)
    */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result=new int[nums.length];
        
        int[] freq=new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]+=1;
        }
        
        for(int i=1;i<freq.length;i++){
            freq[i]+=freq[i-1];
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                result[i]=0;
            }else{
                result[i]=freq[nums[i]-1];
            }
        }
        return result;
    }
}