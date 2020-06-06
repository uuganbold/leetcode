class Solution551 {

    /*
        T:O(N)
        S: O(1)
    */
    public boolean checkRecord(String s) {
        int absent=0;
        int late=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='A'){
                absent++;
                late=0;
            }else if(ch=='L'){
                late++;
            }else{
                late=0;
            }
            if(absent>1||late>2) return false;
        }
        return true;
    }
}