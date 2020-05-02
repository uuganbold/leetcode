class Solution1021 {
    /*
    T: O(n)
    S: O(n)
    */
    public String removeOuterParentheses(String S) {
        int count=0;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='('){
                if(count!=0) builder.append(ch);
                count+=1;
            }else{
                count-=1;
                if(count!=0) builder.append(ch); 
            }
        }
        return builder.toString();
    }
}