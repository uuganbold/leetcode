import java.util.*;
class Solution1385 {
    
    /*
        T: O((M+N)*logN)
        S: O(1)
    */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d){
        int count=0;
        Arrays.sort(arr2);
        
        for(int i=0;i<arr1.length;i++){
            int max=arr1[i]+d;
            int min=arr1[i]-d;
            
            int lo=0;
            int hi=arr2.length;
            while(lo<hi){
                int mi=(lo+hi)/2;
                
                if(arr2[mi]>max){
                    hi=mi;
                }else if(arr2[mi]<min){
                    lo=mi+1;
                }else{
                    ++count;
                    break;
                }
            }
        }
        
        return arr1.length-count;
    }
    
    /*
        T: O(m*n)
        S: O(1)
    */
    public int findTheDistanceValueBF(int[] arr1, int[] arr2, int d) {
        int count=0;  
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d) { count++; break; }
            }
        }
        return arr1.length-count;
    }
}