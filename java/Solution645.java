import java.util.*;
class Solution645 {
    
    /*
        T: O(N)
        S: O(1)
    */
    public int[] findErrorNums(int[] nums){
        
        int duplicated=-1;
        int missing=-1;
        int sum=0;
        
        for(int n:nums){
            
            if(nums[Math.abs(n)-1]<0){
                duplicated=Math.abs(n);
            }else{
                nums[Math.abs(n)-1]*=-1;
            }
            
            sum+=Math.abs(n);
        }
        
        missing=nums.length*(nums.length+1)/2-sum+duplicated;
        
        return new int[]{duplicated,missing};
    }
    
    /*
        T: O(N)
        S: O(N)
    */
    public int[] findErrorNums2(int[] nums){
        int[] occurences=new int[nums.length];
        for(int n:nums){
            occurences[n-1]++;
        }
        int missing=-1;
        int duplicated=-1;
        for(int i=0;i<occurences.length;i++){
            if(occurences[i]==0){
                missing=i+1;
            }else if(occurences[i]==2){
                duplicated=i+1;
            }else if(missing>0&&duplicated>0){
                break;
            }
        }
        
        return new int[]{duplicated,missing};
    }
    
    /*
        T: O(NlogN)
        S: O(1)
    */
    public int[] findErrorNumsSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        int duplicated=-1;
        int sum=0;
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==prev){
                duplicated=nums[i];
            }
            sum+=nums[i];
            prev=nums[i];
        }
        
        int supposedSum=n*(n+1)/2;
        int missing=supposedSum-sum+duplicated;
        
        return new int[]{duplicated,missing};
    }
}