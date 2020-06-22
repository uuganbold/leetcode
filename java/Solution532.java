import java.util.*;
class Solution532 {

    /*
        T: O(N)
        S: O(N)
    */
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        
        int count=0;
        
        if(k==0){
            Map<Integer,Integer> numSet=new HashMap<>();
            for(int n:nums){
                numSet.put(n,numSet.getOrDefault(n,0)+1);
            }
            
            for(int n:numSet.keySet()){
                if(numSet.get(n)>1){
                    count++;
                }
            }
            
        }else{
           Set<Integer> numSet=new HashSet<>();
           for(int n:nums){
                if(numSet.contains(n)){
                    continue;
                }

                if(numSet.contains(n+k)){
                    count++;
                }

                if(numSet.contains(n-k)){
                    count++;
                }
               
                numSet.add(n);

            } 
        }
        
        return count;
    }
}