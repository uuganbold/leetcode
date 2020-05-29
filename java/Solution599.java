
import java.util.*;
class Solution599 {

    /*
        T: O(N+M)
        S: O(N*stringlength)
    */
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1==null|list2==null) return null;
        
        List<String> ans=new ArrayList<String>();
        
        Map<String,Integer> mapResToIndex=new HashMap<>();
        for(int i=0;i<list1.length;i++){
            mapResToIndex.put(list1[i],i);
        }
        
        int min=list1.length+list2.length;
        for(int i=0;i<list2.length;i++){
            
            if(mapResToIndex.containsKey(list2[i])){
                int indexOfThisRes=mapResToIndex.get(list2[i])+i;

                if(indexOfThisRes<min){
                    ans=new ArrayList<>();
                    ans.add(list2[i]);
                    min=indexOfThisRes;
                }else if(indexOfThisRes==min){
                    ans.add(list2[i]);
                }  
            }     
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}