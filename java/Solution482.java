class Solution482 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public String licenseKeyFormatting(String S, int K){
        StringBuilder ans=new StringBuilder();
        
        int counter=K;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)!='-'){
                ans.append(Character.toUpperCase(S.charAt(i)));
                counter--;
                if(counter==0){
                    ans.append('-');
                    counter=K;
                }
            }
        }
        
        if(ans.length()!=0&&ans.charAt(ans.length()-1)=='-') ans.deleteCharAt(ans.length()-1);
        
        return ans.reverse().toString();
    }
    
    public String licenseKeyFormattingTwo(String S, int K) {
        int count=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='-'){
                count++;
            }
        }
        
        if(count==0){
            return "";
        }
        
        int perGroup=count%K;
        if(perGroup==0){
            perGroup=K;
        }
        
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='-'){
                ans.append(Character.toUpperCase(S.charAt(i)));
                perGroup--;  
                if(perGroup==0){
                    ans.append('-');
                    perGroup=K;
                }
            }
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}