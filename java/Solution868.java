class Solution868 {

    /*
        T: O(1)
        S: O(1)
    */
    public int binaryGap(int N) {
        int max=0;
        int dist=-32;
        while(N>0){
            if((N&1)==1){
                if(dist>max) max=dist;
                dist=0;
            }
            dist++;
            N=N>>1;
        }    
        return max;
    }
}