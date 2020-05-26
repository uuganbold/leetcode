class Solution1071 {

    /*
        T: O(N)
        S: O(gcd)
    */
    public String gcdOfStrings(String str1, String str2) {
        int length=gcd(str1.length(), str2.length());
        String divisor=str1.substring(0,length);
        if(isDivisor(str1,divisor)&&isDivisor(str2,divisor)){
            return divisor;
        }
        return "";
    }
    
    private boolean isDivisor(String str, String divisor){
        if(str.length()%divisor.length()!=0) return false;
        int j=0;
        for(int i=0; i< str.length();i++){
            if(j==divisor.length()) {j=0;}
            if(str.charAt(i)!=divisor.charAt(j)){
                return false;
            }
            j++;
        }
        return true;
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}