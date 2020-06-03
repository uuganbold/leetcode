class Solution598 {

    /*
        T: O(ops)
        S: O(1)
    */
    public int maxCount(int m, int n, int[][] ops) {
        int minx=m;
        int miny=n;
        
        for(int[] op:ops){
            if(op[0]<minx) minx=op[0];
            if(op[1]<miny) miny=op[1];
        }
        
        return minx*miny;
    }
}