public class Solution1614 {
    public int maxDepth(String s) {
        int max=0;
        int depth=0;
        for(char ch:s.toCharArray()){
            
            if(ch=='('){
                depth++;
                if(depth>max){
                    max=depth;
                }
            }else if(ch==')'){
                depth--;
            }
        }
        
        return max;
    }
}
