import java.util.*;
class Solution575 {

    /*
        T: O(N)
        S: O(N)
    */
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds=new HashSet<>();
        for(int candy:candies){
            kinds.add(candy);
        }
        
        return Math.min(candies.length/2,kinds.size());
    }
}