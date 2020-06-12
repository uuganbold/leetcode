class Solution172 {
    /*
        T: O(logN)
        S: O(1)
    */
    public int trailingZeroes(int n) {
        int count=0;
        while(n>0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}