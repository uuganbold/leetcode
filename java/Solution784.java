import java.util.*;

class Solution784 {

    /*
        T: O(2^N)
        S: O(N)
    */
    public List<String> letterCasePermutation(String S) {
        List<String> result=new ArrayList<>();
        
        letterCasePermHelper(S.toCharArray(),0,result);
        
        return result;
    }
    
    private void letterCasePermHelper(char[] str, int idx, List<String> result){
        
        if(idx==str.length){
            result.add(new String(str));
            return;
        }
        
        char current=str[idx];
        if(Character.isLetter(current)){          
            letterCasePermHelper(str,idx+1,result);
            str[idx]=(char)(current^32);
            letterCasePermHelper(str,idx+1,result);
            str[idx]=current;
        }else{
            letterCasePermHelper(str,idx+1,result);
        }
        
    }
}