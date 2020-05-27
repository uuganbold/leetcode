class Solution704 {

    /*
        T: O(logN)
        S: O(1)
    */
    public int search(int[] nums, int target) {
        int lo=0;
        int hi=nums.length;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        return -1;
    }
}