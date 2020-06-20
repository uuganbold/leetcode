class Solution28 {
    
    /*
        T: O(H*N)
        S: O(1)
    */
    public int strStr(String haystack, String needle){
        if(needle.length()==0){
            return 0;
        }
        
        for(int i=0;i+needle.length()-1<haystack.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    
    /*
        T: O(H*N)
        S: O(1)
    */
    public int naive(String haystack, String needle){
        if(needle.length()==0){
            return 0;
        }
        
        for(int i=0;i+needle.length()-1<haystack.length();i++){
            int j=0;
            for(;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
    
    /*
        T: O(H+N)
        S: O(N)
    */
    public int KMPAlgorithm(String haystack, String needle) {
         if(needle==null||needle.length()==0){
             return 0;
         }
         
         int[] shift=KMPPatternShift(needle);
         
        int h=0;
        int n=0;
        while(h<haystack.length()&&n<needle.length()){
            if(haystack.charAt(h)==needle.charAt(n)){
                h++;
                n++;
            }else{
                if(n!=0){
                    n=shift[n-1];
                }else{
                    h++;
                }
            }
        }
        
        if(n==needle.length()){
            return h-n;
        }
        return -1;
    }
    
    private int[] KMPPatternShift(String pattern){
        int[] ans=new int[pattern.length()];
        int left=0;
        for(int right=1;right<pattern.length();right++){
            while(left>0&&pattern.charAt(left)!=pattern.charAt(right)){
                left=ans[left-1];
            }
            if(pattern.charAt(right)==pattern.charAt(left)){
                ans[right]=++left;
            }else{
                ans[right]=0;
            }
        }
        
        return ans;
    }
}