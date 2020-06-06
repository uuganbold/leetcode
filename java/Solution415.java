class Solution415 {

    /*
        T: O(max(n1,n2))
        S: O(max(n1,n2))
    */
    public String addStrings(String num1, String num2) {
        char[] result=new char[Math.max(num1.length(),num2.length())+1];
        
        int mem=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        int r=result.length-1;
        
        while(i>=0&&j>=0){
            int val=charToValue(num1.charAt(i--))+charToValue(num2.charAt(j--))+mem;
            result[r--]=valueToChar(val%10);
            mem=val/10;
        }
        
        while(i>=0){
            int val=charToValue(num1.charAt(i--))+mem;
            result[r--]=valueToChar(val%10);
            mem=val/10;
        }
        
        while(j>=0){
            int val=charToValue(num2.charAt(j--))+mem;
            result[r--]=valueToChar(val%10);
            mem=val/10;
        }
        
        result[0]=valueToChar(mem);
        int start=mem>0?0:1;
        return new String(result,start,result.length-start);
    }
    
    private int charToValue(char ch){
        return ch-'0';
    }
    
    private char valueToChar(int v){
        return (char)(v+'0');
    }
}