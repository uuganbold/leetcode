class Solution392 {
    
    public boolean isSubsequence(String s, String t) {
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();
        
        return isSubsequence(sChars,tChars);
    }
    
    /*
        T: O(T)
        S: O(1)
    */
    private boolean isSubsequence(char[] s, char[] t){
        int ss=0;
        int tt=0;
        
        while(ss<s.length&&tt<t.length){
            if(s[ss]==t[tt]){
                ss++;
            }
            tt++;
        }
        
        return ss==s.length;
    }
    
    /*
        T: O(S*T)
        T: O(S*T)
    */
    private int longestCommonSubsequence(char[] s, char[] t){
        int[][] dp=new int[t.length+1][s.length+1];
        
        for(int i=1;i<=t.length;i++){
            for(int j=1;j<=s.length;j++){
                if(t[i-1]==s[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[t.length][s.length];
    }
}