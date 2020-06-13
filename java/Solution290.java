import java.util.*;
class Solution290 {
    
    /*
        T: O(P+S)
        S: O(P+S)
    */
    public boolean wordPattern(String pattern, String str) {
       String[] arr=str.split(" ");
       if(pattern.length()!=arr.length) return false;
       
       Map<Character,Integer> mapForPat=new HashMap<Character,Integer>();
       Map<String,Integer> mapForStr=new HashMap<String,Integer>();
       
       for(int i=0;i<pattern.length();i++){
           int indexP=mapForPat.getOrDefault(pattern.charAt(i),-1);
           int indexS=mapForStr.getOrDefault(arr[i],-1);
           
           if(indexP!=indexS) return false;
           
           mapForPat.put(pattern.charAt(i),i);
           mapForStr.put(arr[i],i);
       }
       
       return true;
   }
   public boolean wordPattern1(String pattern, String str) {
       String[] words=str.split(" ");
       if(pattern.length()!=words.length){
           return false;
       }
       
       Map<Character,String> to=new HashMap<>();
       Map<String,Character> from=new HashMap<>();
       
       for(int i=0;i<words.length;i++){
            char ch=pattern.charAt(i);
            String w=words[i];
           
            if(to.containsKey(ch)){
                 if(!from.containsKey(w)||!to.get(ch).equals(w)||from.get(w)!=ch){
                     return false;
                 }
            }else{
                if(from.containsKey(w)){
                    return false;
                }
                to.put(ch,w);
                from.put(w,ch);
            }
           
       }
       
       return true;
   }
}