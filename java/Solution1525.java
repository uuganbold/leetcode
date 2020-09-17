import java.util.*;
class Solution1525 {

    /*
        T: O(N)
        S: O(26)
    */
    public int numSplits(String s) {
        /*
        a|a|caba
        
        a: 0,5
        b: 4,4
        c: 2:2
        
        1
        */
        
        int[] starts=new int[26];
        int[] ends=new int[26];
        
        Arrays.fill(starts,-1);
        int distCount=0;
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            
            if(starts[ch]==-1){
                starts[ch]=i;
                distCount++;
            }
            ends[ch]=i;
        }
        
        int left=0;
        int right=distCount;
        int ans=0;
        
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(starts[ch]==i){
                left++;
            }
            if(ends[ch]==i){
                right--;
            }
            if(left==right){
                ans++;
            }
        }
        
        return ans;
    }
}