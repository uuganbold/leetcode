class Solution709 {
    /*
    T: O(n)
    S: O(n)
    */
    public String toLowerCase(String str) {
        int diff='A'-'a';
        char[] result=new char[str.length()];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='A'&&ch<='Z') result[i]=(char)(ch-diff);
            else result[i]=ch;
        }
        return new String(result);
    }
}