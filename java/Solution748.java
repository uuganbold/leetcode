class Solution748 {
    
    /*
    T: O(N) N-length of chars
    S: O(1)
    */
    public String shortestCompletingWord(String licensePlate, String[] words) {
         char[] lookupChars=new char[26];
         int a=Character.getNumericValue('a');
         for(char ch:licensePlate.toCharArray()){
             if(Character.isLetter(ch)){
                 lookupChars[Character.getNumericValue(ch)-a]++;
             }
         }
        
         String min=null;
         for(String word:words){
             char[] wordChars=mapToChar(word);
             boolean complete=true;
             for(int i=0;i<wordChars.length;i++){
                 if(wordChars[i]<lookupChars[i]){
                     complete=false;
                     break;
                 }
             }
             
             if(complete&&(min==null||min.length()>word.length())){
                 min=word;
             }
         }
        
        return min;
    }
    
    private char[] mapToChar(String str){
        char[] map=new char[26];
        for(char ch:str.toCharArray()){
            map[ch-'a']++;
        }
        return map;
    }
}