import java.util.*;
class Solution824 {
    
    Set<Character> vowels=new HashSet<>(){
        {
        add('a');
        add('A');
        add('e');
        add('E');
        add('i');
        add('I');
        add('o');
        add('O');
        add('u');
        add('U');
    }};
    
    /*
        T: O(N^2) - for extra 'a'-s
        S: O(N^2) - for extra 'a'-s
    */
    public String toGoatLatin(String S) {
        StringBuilder ans=new StringBuilder();
        
        String[] words=S.split(" ");
        String a="a";

        for(int i=0;i<words.length;i++){
            
            ans.append(' ');
            String word=words[i];
            char start=word.charAt(0);
            if(vowels.contains(start)){
                ans.append(word);
            }else{
                ans.append(word.substring(1)).append(start);
            }
            
            ans.append("ma").append(a);
            a=a+"a";
        }
        
        return ans.toString().substring(1);
    }
}