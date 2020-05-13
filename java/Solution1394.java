import java.util.*;

class Solution1394 {

    /*
        T: O(NlogN)
        S: O(1)
    */
    public int findLucky(int[] arr) {
         int ans=-1;
        Arrays.sort(arr);
        
        int count=1;
        int val=arr[0];
        for(int j=1;j<arr.length;j++){
            if(arr[j]!=val){
                if(count==val){
                    ans=val;
                }
                count=1;
                val=arr[j];
            }else count++;
        }
        if(count==val){
            ans=val;
        }
        
        return ans;
    }
}