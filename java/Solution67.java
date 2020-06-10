class Solution67 {

    /*
        T: O(MAX(A,B))
        S: O(Max(A,B))
    */
    public String addBinary(String a, String b) {
        char[] ans=new char[Math.max(a.length(),b.length())+1];
        int mem=0;
        int i=a.length()-1;
        int j=b.length()-1;
        int k=ans.length-1;
        while(i>=0||j>=0){
            int ac=i>=0?a.charAt(i)-'0':0;
            int bc=j>=0?b.charAt(j)-'0':0;
            ans[k--]=(char)(ac^bc^mem+'0');
            mem=((ac&bc)|(ac&mem)|(bc&mem));
            i--;
            j--;
        }
        
        ans[0]=(char)(mem+'0');
        
        if(mem==0){
            return new String(ans,1,ans.length-1);
        }else{
            return new String(ans);
        }
    }
}