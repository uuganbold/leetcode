import java.util.*;
class Solution1207 {

    /**
     * T: O(N)
     * S: O(N)
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            int count=map.getOrDefault(i,0);
            map.put(i,count+1);
        }
        
        Set<Integer> values=new HashSet<>(map.values());
        return values.size()==map.keySet().size();
    }
}