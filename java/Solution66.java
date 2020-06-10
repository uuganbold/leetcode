import java.util.*;
class Solution66 {

    /*
        T: O(N)
        S: O(1) except result
    */
        public int[] plusOne(int[] digits) {
            if(digits==null||digits.length==0){
                return digits;
            }
            
            int[] ans=new int[digits.length+1];
            
            int carry=1;
            for(int i=digits.length-1;i>=0;i--){
                int val=digits[i]+carry;
                ans[i+1]=val%10;
                carry=val/10;
            }
            ans[0]=carry;
            
            if(carry==0){
                return Arrays.copyOfRange(ans,1,ans.length);
            }
            
            return ans;
        }
}