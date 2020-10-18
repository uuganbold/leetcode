class Solution537 {
    public String complexNumberMultiply(String a, String b) {
        
        int[] num1=parse(a);
        int[] num2=parse(b);
        
        int[] ans={num1[0]*num2[0]-num1[1]*num2[1], num1[0]*num2[1]+num1[1]*num2[0]};
        
        return toString(ans);
    }
    
    private int[] parse(String a){
        int[] ans=new int[2];

        ans[0]=Integer.parseInt(a.substring(0,a.indexOf("+")));
        ans[1]=Integer.parseInt(a.substring(a.indexOf("+")+1, a.length()-1));
        
        return ans;
    }
    
    private String toString(int[] a){
        return String.valueOf(a[0])+"+"+String.valueOf(a[1])+"i";
    }
}