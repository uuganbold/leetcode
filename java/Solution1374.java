class Solution1374 {
    /**
     * T: O(n)
     * S: O(n)
     */
    public String generateTheString(int n) {
        char[] result=new char[n];
        for(int i=1;i<result.length;i++){
            result[i]='a';
        }
        if(n%2==0) result[0]='b';
        else result[0]='a';
        return new String(result);
    }
}