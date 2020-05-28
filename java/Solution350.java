import java.util.*;
class Solution350 {
    /*
        T: O(NlogN+MlogM)
        if already sorted: O(N+M)
        S: O(1)
    */
    public int[] intersectMerge(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] ans=new int[Math.min(nums1.length,nums2.length)];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                ans[k++]=nums1[i];
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        
        return Arrays.copyOf(ans,k);
    } 
    
    /*
        T: O(N+M)
        S: O(N)
    */
    public int[] intersectMap(int[] nums1, int[] nums2) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int num:nums1){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        
        int j=0;
        for(int i=0;i<nums2.length;i++){
            int num=nums2[i];
            int count=freq.getOrDefault(num,0);
            if(count>0){
                nums2[j++]=num;
                freq.put(num,count-1);
            }
        }
        
        return Arrays.copyOf(nums2,j);
    }
}