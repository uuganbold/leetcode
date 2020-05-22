class Solution896 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean isMonotonic(int[] A) {
        int dir=0;
        for(int i=0;i<A.length-1;i++){
            int c=Integer.compare(A[i],A[i+1]);
            if(c!=0){
                if(dir!=0&&dir!=c) return false;
                dir=c;
            }
        }
        
        return true;
    }
}