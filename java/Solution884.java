import java.util.*;
class Solution884 {

    /**
     * T: O(A+B)
     * S: O(A+B)
     */
    public String[] uncommonFromSentences(String A, String B) {
         Map<String,Integer> words=new HashMap<>();
         
         for(String word:A.split(" ")){
             words.put(word,words.getOrDefault(word,0)+1);
         }
        
        for(String word:B.split(" ")){
             words.put(word,words.getOrDefault(word,0)+1);
         }
        
        List<String> ans=new LinkedList<>();
        for(String word:words.keySet()){
            if(words.get(word)==1) ans.add(word);
        }
        
        return ans.toArray(new String[ans.size()]);
        
    }
}