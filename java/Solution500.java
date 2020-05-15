import java.util.*;
class Solution500 {
    
    int[] keyMap;
    
    public Solution500(){
        keyMap=new int[26];
        String[] keyboard=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        for(int i=0;i<keyboard.length;i++){
            String keys=keyboard[i];
            for(char key:keys.toCharArray()){         
                keyMap[key-'a']=i;
            }
        }
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public String[] findWords(String[] words) {
        List<String> result=new ArrayList<>();
        
        for(String word:words){
            
            int row=keyMap[Character.toLowerCase(word.charAt(0))-'a'];
            boolean isOneRow=true;
            
            for(char ch:word.toCharArray()){
                int thisRow=keyMap[Character.toLowerCase(ch)-'a'];
                if(row!=thisRow) {isOneRow=false; break;}
            }
            
            if(isOneRow) result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
}