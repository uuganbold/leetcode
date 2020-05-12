import java.util.*;
class Solution1047 {
    
    /*
        T: O(N)
        S: O(N)
     */
    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int i = 0;
        
        for(int j = 0; j < S.length(); j++){
            if(i > 0 && stack[i - 1] == S.charAt(j)){
                i--;
            }
            else{
                stack[i] = S.charAt(j);
                i++;
            }
        }
        return new String(stack, 0, i);
    }
    
    /*
        T: O(N)
        S: O(N)
     */
    public String removeDuplicatesStack(String S) {
        Stack<Character> stack=new Stack<>();
        
        for(char ch:S.toCharArray()){
            if(!stack.isEmpty()&&stack.peek()==ch) stack.pop();
            else stack.push(ch);
        }
        
        char[] result=new char[stack.size()];
        for(int i=result.length-1;i>=0;i--){
             result[i]=stack.pop();
        }
        
        return new String(result);
    }
}