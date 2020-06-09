class Solution38 {
    
    /*
        T: O(2^N)
        S: O(2^N)
    */
    public String countAndSay(int n){
        
        StringBuilder prev;
        StringBuilder ans=new StringBuilder("1");
        for(int i=2;i<=n;i++){
            prev=ans;
            ans=new StringBuilder();
            
            int count=1;
            for(int j=1;j<prev.length();j++){
                if(prev.charAt(j)!=prev.charAt(j-1)){
                    ans.append(count).append(prev.charAt(j-1));
                    count=1;
                }else{
                    count++;
                }
            }
            ans.append(count).append(prev.charAt(prev.length()-1));
        }
        
        return ans.toString();
        
    }
    
    public String countAndSayRecursive(int n) {
        
        if(n==1){
            return "1";
        }
        String prev=countAndSay(n-1);
        StringBuilder ans=new StringBuilder();
        int count=1;
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i)!=prev.charAt(i-1)){
                ans.append(count).append(prev.charAt(i-1));
                count=1;
            }else{
                count++;
            }
        }
        ans.append(count).append(prev.charAt(prev.length()-1));
        return ans.toString();
    }
    
}