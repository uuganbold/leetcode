import java.util.*;

class Solution1002 {
    
    /*
        T: O(C) C- number of all characters.
        S: O(26)
    */
    public List<String> commonChars(String[] A) {
        if(A==null||A.length==0) return null;
        
        int[] chars=extractChars(A[0]);
        
        for(int i=1;i<A.length;i++){
            
            int[] otherChars=extractChars(A[i]);
            
            for(int j=0;j<chars.length;j++){
                chars[j]=Math.min(chars[j],otherChars[j]);
            }
        }
        
        List<String> result=new ArrayList<>();
        
        for(int i=0;i<chars.length;i++){
            
            while(chars[i]>0){
                result.add(Character.toString(i+'a'));
                chars[i]--;
            }
        }
        return result;
    }
    
    private int[] extractChars(String str){
        int[] chars=new int[26];
        for(char ch:str.toCharArray()){
            chars[ch-'a']++;
        }
        return chars;
    }
}