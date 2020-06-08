class Solution1470 {

    /*
        T: O(N)
        S: O(N)
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int j=0;
        for(int i=0;i<n;i++){
            ans[j++]=nums[i];
            ans[j++]=nums[i+n];
        }
        return ans;
    }
}