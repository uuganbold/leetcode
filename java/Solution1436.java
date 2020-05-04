import java.util.*;
class Solution1436 {

    /*
    T: O(n)
    S: O(n)
    */
    public String destCity(List<List<String>> paths) {
        Set<String> sities=new HashSet<>();
        for(List<String> pair:paths){
            sities.add(pair.get(0));
            sities.add(pair.get(1));
        }
        
        for(List<String> pair:paths){
            sities.remove(pair.get(0));
        }
        
        return sities.iterator().next();
    }
}