import java.util.*;
class Solution1051 {
    /*
    T: O(NlogN)
    S: O(N)
    */
    public int heightChecker(int[] heights) {
        int[] sorted=heights.clone();
        Arrays.sort(sorted);
        
        int count=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=sorted[i]) count++;
        }
        
        return count;
    }
}