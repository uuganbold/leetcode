class Solution1221 {
    /*
    T: O(n)
    S: O(1)
    */
    public int balancedStringSplit(String s) {
        int balance=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='R') balance+=1;
            else balance-=1;
            if(balance==0) count++;
        }
        return count;
    }
}