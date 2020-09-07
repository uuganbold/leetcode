class Solution1576 {

    /*
        T: O(N)
        S: O(N)
    */
    public String modifyString(String s) {
        char[] ans=new char[s.length()];
        
        char prev=(char)('a'-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='?'){
                ans[i]=next(prev);
            }else{
                if(ch==prev){
                    ans[i-1]=next(ch);
                }
                ans[i]=ch;
            }
            
            prev=ans[i];
            
        }
        
        return new String(ans);
    }
    
    private char next(char ch){
        int n=ch+1;
        if(n>'z'){
            n='a';
        }
        
        return (char)n;
    }
}