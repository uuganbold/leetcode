class Solution461 {
    /**
     * T: O(1)
     * S: O(1)
     */
    public int hammingDistance(int x, int y) {
        int result=x^y;
        int count=0;
        while(result>0){
            count+=result&1;
            result=result>>1;
        }
        return count;
    }
}