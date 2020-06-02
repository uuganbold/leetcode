class Solution997 {
    
    /*
        T: O(N+TRUST)
        S: O(N)
    */
    public int findJudge(int N, int[][] trust) {
        int[] citizens=new int[N];
        for(int[] oneTrust:trust){
            citizens[oneTrust[0]-1]--;
            citizens[oneTrust[1]-1]++;
        }
        
        int found=-1;
        for(int i=0;i<N;i++){
            int citizen=citizens[i];
            if(citizen==N-1){
                if(found>=0) return -1;
                found=i;
            }
        }
        
        return found>=0?found+1:-1;
    }
}