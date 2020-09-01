class Solution1111 {
    /*
        T: O(N)
        S: O(1)
    */
    public int[] maxDepthAfterSplit(String seq) {
        /*
          [0111000110001110 
           (()(()(())())())
           open=0
           curr=0
           0111000110001110
           
           (-> increase open, write curr, change curr
           )-> decrease open, change curr, write curr
        */
        
        int curr=0;
        int[] ans=new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            char ch=seq.charAt(i);
            if(ch=='('){
                ans[i]=curr;
                curr=1-curr;
            }else{
                curr=1-curr;
                ans[i]=curr;
            }
        }
        
        
        return ans;
    }
}