class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /*
        T:O(n^2)
        S:O(1)
        */
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]) count+=1;
            }
            result[i]=count;
        }
        return result;
    }
}