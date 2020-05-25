class Solution953 {

    /*
        T: O(N)
        S: O(1)
    */
    public boolean isAlienSorted(String[] words, String order) {
         int[] charSet=new int[26];
        
        for(int i=0;i<order.length();i++){
            charSet[order.charAt(i)-'a']=i;
        }
        
        String prev=words[0];
        for(int i=1;i<words.length;i++){
            String thisWord=words[i];
            
            for(int j=0;j<prev.length();j++){
                if(j>=thisWord.length()) return false;
                
                int prevPos=charSet[prev.charAt(j)-'a'];
                int thisPos=charSet[thisWord.charAt(j)-'a'];
                
                if(prevPos==thisPos) continue;
                if(prevPos<thisPos) break;
                return false;
            }
            
            prev=thisWord;
        }
        
        return true;
    }
}