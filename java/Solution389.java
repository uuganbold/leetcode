class Solution389 {

    /*
        T: O(N)
        S: O(1)
    */
    public char findTheDifference(String s, String t) {
        int chars=0;
        for(char ch:s.toCharArray()){
            chars^=ch;
        }
        
        for(char ch:t.toCharArray()){
            chars^=ch;
        }
        
        return (char)chars;
        
    }
}