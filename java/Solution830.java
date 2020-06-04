import java.util.*;
class Solution830 {

    /*
        T: O(N)
        S: O(1)
    */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans=new ArrayList<>();
        char current=S.charAt(0);
        int count=1;
        for(int i=1;i<S.length();i++){
            if(S.charAt(i)!=current){
                if(count>=3){
                    ans.add(List.<Integer>of(new Integer[]{i-count,i-1}));
                }
                current=S.charAt(i);
                count=1;
            }else{
                count++;
            }
        }
        if(count>=3){
            ans.add(List.<Integer>of(new Integer[]{S.length()-count,S.length()-1}));
        }
        
        return ans;
    }
}