class Solution693 {

    /*
        T: O(1)
        S: O(1)
    */
    public boolean hasAlternatingBits(int n) {
        int k=n&1;
        n=n>>1;
        while(n>0){
            int g=n&1;
            if(k==g) return false;
            k=g;
            n=n>>1;
        }
        return true;
    }
}