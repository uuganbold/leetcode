import java.util.*;

class Solution1078 {

    /*
        T: O(N)
        S: O(K)
    */
    public String[] findOcurrences(String text, String first, String second) {
        String[] words=text.split(" ");
        
        List<String> result=new ArrayList<>();
        
        for(int i=0;i<words.length-2;i++){
            String word=words[i];
            String nextWord=words[i+1];
            String nextNextWord=words[i+2];
            
            if(word.equals(first)&&nextWord.equals(second)){
                result.add(nextNextWord);
            }
            
        }
        
        return result.toArray(new String[0]);
        
    }
}