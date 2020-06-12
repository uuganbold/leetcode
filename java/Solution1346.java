import java.util.*;
class Solution1346 {

    /*
        T: O(N)
        S: O(N)
    */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int n:arr){
            if(set.contains(n*2)||(n%2==0&&set.contains(n/2))){
                return true;
            };
            set.add(n);
        }
        
        return false;
    }
}