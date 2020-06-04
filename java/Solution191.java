public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeightOneByOne(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    
    public int hammingWeight(int n){
        int bits=0;
        while(n!=0){
            bits++;
            n&=(n-1);
        }
        return bits;
    }
}