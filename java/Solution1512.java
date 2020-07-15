class Solution1512 {

    /*
        T: O(N)
        S: O(100)
    */
    public int numIdenticalPairs(int[] nums) {

        int[] counts=new int[100]; //ith -> count i+1
        int ans=0;
        for(int n:nums){
            ans+=counts[n-1];
            counts[n-1]++;
        }
        return ans;
    }
}