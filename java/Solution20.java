import java.util.*;
class Solution20 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public boolean isValid(String s){
        char[] stack=new char[s.length()];
        int pointer=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='['||ch=='{'){
                stack[pointer++]=ch;
            }else{
                if(pointer==0){
                    return false;
                }
                char pair=stack[--pointer];
                if(ch==')'&&pair!='('||
                  ch==']'&&pair!='['||
                  ch=='}'&&pair!='{'){
                    return false;
                }
            }
        }
        
        return pointer==0;
        
    }
    
    public boolean isValidStack(String s) {
        Stack<Character> stack=new Stack<>();
        
        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char pair=stack.pop();
                if(ch==')'&&pair!='('||
                  ch==']'&&pair!='['||
                  ch=='}'&&pair!='{'){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}