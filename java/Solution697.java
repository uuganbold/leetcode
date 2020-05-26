import java.util.*;
class Solution697 {

    /*
        T: O(N)
        S: O(N)
    */
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> freqStartEnd=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int[] iFreq=freqStartEnd.getOrDefault(nums[i],new int[]{0,i,i});
            iFreq[0]++;
            iFreq[2]=i;
            freqStartEnd.put(nums[i],iFreq);
        }
        
        int degree=0;
        int shortest=nums.length+1;
        for(int i:freqStartEnd.keySet()){
            int[] iFreq=freqStartEnd.get(i);
            int length=iFreq[2]-iFreq[1]+1;
            if(iFreq[0]>degree){
                degree=iFreq[0];
                shortest=length;
            }else if(iFreq[0]==degree){
                if(shortest>length){
                    shortest=length;
                }
            }
        }
        
        return shortest;
    }
}