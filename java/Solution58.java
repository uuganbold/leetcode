class Solution58 {
    
    /*
        S: O(N)
        S: O(1)
    */
    public int lengthOfLastWord(String s){
        int j=s.length()-1;
        while(j>=0&&s.charAt(j)==' '){
            j--;
        }
        
        if(j<0){
            return 0;
        }
        int i=j;
        while(i>=0&&s.charAt(i)!=' '){
            i--;
        }
        return j-i;
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public int lengthOfLastWordSplit(String s) {
         String[] words= s.split(" ");
        if(words.length==0){
            return 0;
        }else{
            return words[words.length-1].length();
        }
    }
}