import java.util.*;
class Solution119 {

    /*
        T: O(R^2)
        S: O(N)
    */
    public List<Integer> getRow(int rowIndex) {
        int[] ans=new int[rowIndex+1];
        ans[0]=1;
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>0;j--){
                ans[j]=ans[j]+ans[j-1];
            } 
        }
        
        List<Integer> result=new ArrayList<>(ans.length);
        for(int N:ans){
            result.add(N);
        }
        return result;
    }
}