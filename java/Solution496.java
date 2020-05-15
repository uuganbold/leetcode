import java.util.*;
class Solution496 {

    /*
        T: O(N2)
        S: O(N2)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nextGreater=new HashMap<>();
        
        int[] stack=new int[nums2.length];
        int pointer=0;
        
        for(int i=0;i<nums2.length;i++){
             while(pointer>0&&nums2[i]>stack[pointer-1]){
                 nextGreater.put(stack[pointer-1],nums2[i]);
                 pointer--;
             }    
             stack[pointer++]=nums2[i];
        }
        
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=nextGreater.getOrDefault(nums1[i],-1);
        }
        
        return result;
    }
}