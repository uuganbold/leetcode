class Solution171 {

    /*
        T:O(N)
        S:O(1)
    */
    public int titleToNumber(String s) {
        int ans=0;
        for(char ch:s.toCharArray()){
            ans=ans*26+(ch-'A'+1);
        }
        
        return ans;
    }
}