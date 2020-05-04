import java.util.*;
class Solution961 {
    /**
     * T: O(N)
     * S: O(N)
     */
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:A){
            if(!set.add(i)) return i;
        }
        throw null;
    }
}