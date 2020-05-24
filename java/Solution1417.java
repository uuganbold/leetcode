class Solution1417 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public String reformat(String s){
        char[] ans=new char[s.length()];
        int l=0;
        int d=s.length()-1;
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                ans[l++]=ch;
            }else ans[d--]=ch;
        }
        
        int letLength=l;
        int digLength=ans.length-l;
        
        if(Math.abs(letLength-digLength)>=2) return "";
        
        int left=1;
        int right=ans.length-1;
        
        if(letLength==digLength){
            right--;
        }else if(letLength<digLength){
            left--;
            right--;
        }
        
        while(left<right){
            char temp=ans[left];
            ans[left]=ans[right];
            ans[right]=temp;
            left+=2;
            right-=2;
        }
        
        return new String(ans);
        
    }

    /*
        T: O(N)
        S: O(N)
    */
    public String reformatMessy(String s) {
        
        char[] ans=new char[s.length()+2];

        int l=1;
        int d=2;
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                if(l>=ans.length) return "";
                ans[l]=ch;
                l+=2;
            }else{
                if(d>=ans.length) return "";
                ans[d]=ch;
                d+=2;
            }
        }
        
        if(ans[ans.length-2]==0) {
            if(Character.isLetter(ans[ans.length-1])) return "";
            ans[0]=ans[ans.length-1];
            return new String(ans,0,s.length());
        }else{
            return new String(ans,1,s.length());
        }
    }
}