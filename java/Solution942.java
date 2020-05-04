class Solution942 {

    /**
     * T: O(N)
     * S: O(1)
     */
    public int[] diStringMatch(String S) {
        int[] result=new int[S.length()+1];
        int smallest=0;
        int largest=S.length();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='I') result[i]=smallest++;
            else result[i]=largest--;
        }
        result[S.length()]=smallest;
        return result;
    }
}