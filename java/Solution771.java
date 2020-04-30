class Solution771 {
    /*
        T:O(n*m)
        S:O(1)
    */
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for(char ch:S.toCharArray()){
            if(J.indexOf(ch)>=0) count++;
        }
        return count;
    }
}