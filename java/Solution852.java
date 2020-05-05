class Solution852 {

    /**
     * T: O(logN)
     * S: O(1)
     */
    public int peakIndexInMountainArray(int[] A) {
        int left=0;
        int right=A.length;
        while(left<right){
            int mid=(left+right)/2;
            if(A[mid]<A[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}