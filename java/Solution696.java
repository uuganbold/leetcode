class Solution696 {

    /*
        T: O(N)
        S: O(1)
    */
    public int countBinarySubstrings(String s) {
        
        int ans=0;
        int prevCount=0;
        int currentCount=0;
        char current=0;
        
        for(char ch:s.toCharArray()){
            if(ch!=current){
                ans+=Math.min(prevCount,currentCount);
                prevCount=currentCount;
                current=ch;
                currentCount=1;
            }else{
                currentCount++;
            }
        }
        
        ans+=Math.min(currentCount,prevCount);
        
        return ans;
        
    }
}