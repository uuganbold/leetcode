class Solution1309 {
    /*
    T: O(n)
    S: O(n)
    */
    public String freqAlphabets(String s) {
        
        StringBuilder builder=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            int code;
            if(ch=='#'){
                code=Integer.parseInt(s.substring(i-2,i));
                i=i-2;
            }else{
                code=ch-'1'+1;
            }
            builder.insert(0,(char)('a'+code-1));
        }
        
        return builder.toString();
    }
}