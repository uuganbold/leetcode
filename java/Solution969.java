import java.util.*;
class Solution969 {

    /*
        O(N^2)
    */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        
        int right=arr.length;
        while(right>0){
            int max=0;
            for(int i=0;i<right;i++){
                if(arr[i]>arr[max]){
                    max=i;
                }
            }
            if(max<right-1){
                ans.add(max+1);
                pancakeFlip(arr,max+1);
                ans.add(right);
                pancakeFlip(arr,right); 
            }
            right--;
        }
        
        return ans;
    }
    
    private void pancakeFlip(int[] arr, int right){
        int i=0;
        int j=right-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    
}