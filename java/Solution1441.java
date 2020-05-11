import java.util.*;

class Solution1441 {

    /*
        T: O(N)
        S: O(1)
    */
    public List<String> buildArray(int[] target, int n) {
        List<String> result=new ArrayList<>();
        
        int cur=0;
        for(int t:target){
            result.add("Push");
            
            for(int i=cur;i<t-1;i++){
                result.add("Pop");
                result.add("Push");
            }
            
            cur=t;
        }
        
        return result;
    }
}