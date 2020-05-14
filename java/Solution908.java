class Solution908 {
    /*
        T: O(N)
        S: O(1)
    */
    public int smallestRangeI(int[] A, int K) {
        int min=A[0];
        int max=A[0];
        
        for(int i=1;i<A.length;i++){
            if(A[i]>max) max=A[i];
            if(A[i]<min) min=A[i];
        }
        
        if(min+K>max-K) return 0;
        else return max-2*K-min;
    }
}