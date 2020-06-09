class Solution231 {
    /*
        T: O(1)
        S: O(1)
    */
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }
}