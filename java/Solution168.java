class Solution168 {

    /*
        T: O(logN)
        S: O(N)
    */
    public String convertToTitle(int n) {
        if(n<1){
            return null;
        }
        
        StringBuilder ans=new StringBuilder();
        while(n>0){
            ans.insert(0,(char)('A'+(n-1)%26));
            n=(n-1)/26;
        }
        
        return ans.toString();
        
    }
}