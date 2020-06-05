class Solution541 {

    /*
        T: O(N)
        S: O(N)
    */
    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        int i=0;
        while(i+k-1<chars.length){
            reverse(chars,i,i+k-1);
            i+=2*k;
        }
        if(i<chars.length){
            reverse(chars,i,chars.length-1);
        }
        
        return new String(chars);
    }
    
    private void reverse(char[] s, int left, int right){
        while(left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}