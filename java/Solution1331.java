import java.util.*;
class Solution1331 {

    /*
        T: O(NlogN)
        S: O(N)
    */
    public int[] arrayRankTransform(int[] arr) {
        if(arr==null||arr.length==0) return arr;
        
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer,Integer> mapToRank=new HashMap<>();
        
        mapToRank.put(sorted[0],1);
        
        int rank=1;
        for(int i=1;i<sorted.length;i++){
            if(sorted[i]!=sorted[i-1]){
                rank++;
                mapToRank.put(sorted[i],rank);
            }
        }
        
        int[] ans=new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            ans[i]=mapToRank.get(arr[i]);
        }
        
        return ans;
    }
}