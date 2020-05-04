import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max) max=candies[i];
        }
        
        List<Boolean> result=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max) result.add(true);
            else result.add(false);
        }
        
        return result;
    }

    public List<Boolean> kidsWithCandiesStream(int[] candies, int extraCandies) {
        int max=Arrays.stream(candies).max().getAsInt();
        
        List<Boolean> result=new ArrayList<>();
        Arrays.stream(candies).forEach(n->result.add(n+extraCandies>=max));
        
        return result;
    }
}