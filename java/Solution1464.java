import java.util.*;
class Solution1464 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public int maxProduct(int[] nums){
        int max1=0;
        int max2=0;
        
        for(int i=0;i<nums.length;i++){
            int n=Math.abs(nums[i]);
            if(n>max1){
                max2=max1;
                max1=n;
            }else if(n>max2){
                max2=n;
            }
        }
        
        return (max1-1)*(max2-1);
        
    }
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public int maxProductSort(int[] nums){
        Integer[] newArray=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            newArray[i]=nums[i];
        }
        
        Arrays.sort(newArray,(e1,e2)->{
            return Math.abs(e2)-Math.abs(e1); 
        });
        
        return (newArray[0]-1)*(newArray[1]-1);
        
    }
    
    /*
        T: O(n^2)
        S: O(1)
    */
    public int maxProductBF(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int val=(nums[i]-1)*(nums[j]-1);
                if(val>max) max=val;
            }
        }
        return max;
    }
}