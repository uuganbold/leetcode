class Solution459 {

    /*
        T: O(N^2)
        S: O(1)
    */
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<=s.length()/2;i++){
            if(s.length()%i==0){
                if(isRepeated(s,i)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isRepeated(String s, int i){
        int times=s.length()/i;
        
        for(int t=1;t<times;t++){
            for(int j=0;j<i;j++){
                if(s.charAt(j)!=s.charAt(j+t*i)){
                    return false;
                }
            }
        }
        
        return true;
    }
}