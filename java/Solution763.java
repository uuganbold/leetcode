import java.util.*;
class Solution763{

    /*
        T: O(2*N)
        S: O(26)
    */
    public List<Integer> partitionLabels(String S) {
        int[] ends=new int[26];
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            ends[index]=i;
        }
        
        List<Integer> result=new ArrayList<Integer>();
        int start=-1;
        int end=0;
        for(int i=0;i<S.length();i++){
            int index=S.charAt(i)-'a';
            if(ends[index]>end) end=ends[index];
            if(i==end){
                result.add(end-start);
                start=end;
            }
        }
        return result;
    }
    
    
    /*
        T: O(N+26*log26+26)
        S: O(2*26)
    */
    public List<Integer> partitionLabels2(String S) {
        int[][] startAndEnd=new int[26][2];
        for(int i=0;i<S.length();i++){
            int idx=S.charAt(i)-'a';
            if(startAndEnd[idx][0]==0){
                startAndEnd[idx][0]=i+1;
            }
            startAndEnd[idx][1]=i+1;
        }
        
        Arrays.sort(startAndEnd,(a,b)->{
            return a[0]-b[0];
        });
        
        int start=0;
        int end=0;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<startAndEnd.length;i++){
            if(startAndEnd[i][0]==0){
                continue;
            }
            if(startAndEnd[i][0]>end){
                int len=end-start+1;
                if(start!=0){
                    ans.add(len);
                }
                start=startAndEnd[i][0];
                end=startAndEnd[i][1];
            }else{
                end=Math.max(end,startAndEnd[i][1]);
            }
        }
        
        ans.add(end-start+1);
        
        return ans;
    }
}