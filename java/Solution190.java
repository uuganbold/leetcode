public class Solution190 {
    // you need treat n as an unsigned value

    /*
        T: O(1)
        S: O(1)
    */
    public int reverseBits(int n) {
        int ans=0;
        for(int i=0;i<32;i++){
            ans=(ans<<1)|(n&1);
            n=n>>1;
        }
        return ans;
    }
}