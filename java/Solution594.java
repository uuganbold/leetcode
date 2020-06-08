import java.util.*;
class Solution594 {

    /*
        T: O(N)
        S: O(N)
    */
    public int findLHS(int[] nums) {
        Map<Integer,Integer> countMap=new HashMap<>();
        
        int max=0;
        for(int n:nums){
            int length=countMap.getOrDefault(n,0)+1;
            countMap.put(n,length);
            if(countMap.containsKey(n-1)){
                max=Math.max(max,length+countMap.get(n-1));
            }
            
            if(countMap.containsKey(n+1)){
                max=Math.max(max,length+countMap.get(n+1));
            }
        }
        
        return max;
    }
}