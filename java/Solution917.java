class Solution917 {

    /*
        T: O(N)
        S: O(N)
    */
    public String reverseOnlyLetters(String S) {
        char[] content=S.toCharArray();
        int lo=0;
        int hi=content.length-1;
        
        while(lo<hi){
            if(!Character.isLetter(content[lo])) {lo++; continue;}
            if(!Character.isLetter(content[hi])) {hi--; continue;}
            
            char temp=content[lo];
            content[lo]=content[hi];
            content[hi]=temp;
            lo++;
            hi--;
        }
        
        return new String(content);
    }
}