import java.util.*;
class Solution349 {

    /*
        T: O(n1+n2)
        S: O(n1+n2)
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> firstSet=new HashSet<>();
        Set<Integer> secondSet=new HashSet<>();
        for(int n:nums1){
            firstSet.add(n);
        }
        
        for(int n:nums2){
            if(firstSet.contains(n)) secondSet.add(n);
        }
        
        int[] ans=new int[secondSet.size()];
        int i=0;
        for(int n:secondSet){
            ans[i++]=n;
        }
        
        return ans;
    }
}