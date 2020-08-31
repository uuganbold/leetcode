public class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
         for(int start=0;start<=arr.length-m*k;start++){
             int n=1;
             
             checkCount:
             while(n<k){
                 for(int i=0;i<m;i++){
                     if(arr[start+i]!=arr[start+m*n+i]){
                         break checkCount;
                     }
                 }
                 n++;
             }
             if(n==k){
                 return true;
             }
         }
        
        return false;
    }
}