class Solution941 {
    /**
     * T: O(N)
     * S: O(1)
     */
    public boolean validMountainArray(int[] A) {
         int i=0;
         while(i+1<A.length&&A[i+1]>A[i]){
             i++;
         }
        
        if(i==0||i==A.length-1){
            return false;
        }
        
        while(i+1<A.length&&A[i+1]<A[i]){
            i++;
        }
        
        return i==A.length-1;
    }
}