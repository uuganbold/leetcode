import java.util.*;
class Solution1200 {

    /*
        T: O(NlogN)
        S: O(N)
    */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int currentDiff=arr[i]-arr[i-1];
            if(currentDiff<minDiff){
                result=new ArrayList<>();
                minDiff=currentDiff;
            }
            
            if(currentDiff==minDiff){
                List<Integer> pair=new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        
        return result;
    }
}