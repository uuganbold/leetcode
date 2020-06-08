class Solution844 {
    
    /*
        T: O(S+T)
        S: O(S+T)
    */
    public boolean backspaceCompare(String S, String T){
         return buildStr(S).equals(buildStr(T));
    }
    
    private String buildStr(String S){
        char[] chars=new char[S.length()];
        int pointer=0;
        for(char ch:S.toCharArray()){
            if(ch=='#'){
                if(pointer>0) pointer--;
            }else{
                chars[pointer++]=ch;
            }
        }
        
        return new String(chars,0,pointer);
    }
    
    /*
        T: O(S+T)
        S: O(1)
    */
    public boolean backspaceCompareBackward(String S, String T) {
        if(S==null&&T==null){
            return true;
        }
        if(S==null||T==null){
            return false;
        }
        
        int s=S.length()-1;
        int t=T.length()-1;
        
        int sBackspace=0;
        int tBackspace=0;
        
        while(s>=0||t>=0){
            
            while(s>=0){
                if(S.charAt(s)=='#'){
                    sBackspace++;
                }else if(sBackspace>0){
                    sBackspace--;
                }else{
                    break;
                }
                s--;
            }
            
            while(t>=0){
                if(T.charAt(t)=='#'){
                    tBackspace++;
                }else if(tBackspace>0){
                    tBackspace--;
                }else{
                    break;
                }
                t--;
            }
            
            if(s>=0&&t>=0&&S.charAt(s)!=T.charAt(t)){
                return false;
            }
            
            if((s>=0)!=(t>=0)){
                return false;
            }
            
            s--;
            t--;
        }
        
          
        return true;
    }
}