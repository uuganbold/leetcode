import java.util.*;
class Solution205 {
    
    /*
        T: O(N)
        S: O(C)
    */
    public boolean isIsomorphic(String s, String t) {
         return canCharactersBeReplaced(s, t) && canCharactersBeReplaced(t, s);
     }
     
     private boolean canCharactersBeReplaced(String s, String t) {
         int[] mapping = new int[256];
         
         for (int i = 0; i < s.length(); i++) {
             char from = s.charAt(i);
             char to = t.charAt(i);
             
             if (mapping[from] == 0)
                 mapping[from] = to;
             
             if (mapping[from] != to)
                 return false;
         }
         
         return true;
     }
     
     public boolean isIsomorphicOneTraverse(String s, String t){
         if(s.length()!=t.length()){
             return false;
         }
         
         int[] map=new int[256];
         int[] reversed=new int[256];
         
         for(int i=0;i<s.length();i++){
             char from=s.charAt(i);
             char to=t.charAt(i);
             
             if(map[from]==0){
                 if(reversed[to]!=0){
                     return false;
                 }
                 map[from]=to;
                 reversed[to]=from;
             }else{
                 if(map[from]!=to||reversed[to]==0||reversed[to]!=from){
                     return false;
                 }
             }
         }
         
         return true;
         
     }
     
     public boolean isIsomorphicUnicode(String s, String t) {
         if(s.length()!=t.length()){
             return false;
         }
         
         Map<Character,Character> map=new HashMap<>();
         Map<Character,Character> reversed=new HashMap<>();
         
         for(int i=0;i<s.length();i++){
             char from=s.charAt(i);
             char to=t.charAt(i);
             if(map.containsKey(from)){
                 if(map.get(from)!=to||
                    !reversed.containsKey(to)||
                    reversed.get(to)!=from){
                     
                     return false;
                 }
             }else{
                 if(reversed.containsKey(to)){
                     return false;
                 }
                 map.put(from,to);
                 reversed.put(to,from);
             }
         }
         
         return true;
     }
 }