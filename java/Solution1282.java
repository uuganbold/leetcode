import java.util.*;
class Solution1282 {
    
    /*
        T: O(N)
        S: O(N)
    */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<groupSizes.length;i++){
            List<Integer> group=map.getOrDefault(groupSizes[i],new ArrayList<Integer>());
            group.add(i);
            if(group.size()==groupSizes[i]){
                ans.add(group);
                group=new ArrayList<>();
            }
            map.put(groupSizes[i],group);
        }
        
        return ans;
    }
}