import java.util.*;
class Solution1170 {
    
    /*
        T: O(Q+W)
        S: O(1)
    */
    public int[] numSmallerByFrequency(String[] queries, String[] words){
         int[] freq=new int[12];
         for(int i=0;i<words.length;i++){
             freq[F(words[i])]++;
         }
        
         for(int i=9;i>0;i--){
              freq[i]=freq[i]+freq[i+1];
         }
        
         int[] ans=new int[queries.length];
         for(int i=0;i<queries.length;i++){
             ans[i]=freq[F(queries[i])+1];
         }
        
        return ans;
    }
    
    /*
        T: O(NlogN)
        S: O(N)
    */
    public int[] numSmallerByFrequencySlow(String[] queries, String[] words) {
        int[] queryF=new int[queries.length];
        int[] wordF=new int[words.length];
        
        for(int i=0;i<queries.length;i++){
            queryF[i]=F(queries[i]);
        }
        
        for(int i=0;i<words.length;i++){
            wordF[i]=F(words[i]);
        }
        
        Arrays.sort(wordF);
        
        int[] ans=new int[queries.length];
        for(int i=0;i<queryF.length;i++){
            int query=queryF[i];
            int lo=0;
            int hi=wordF.length;
            while(lo<hi){
                int mi=(lo+hi)/2;
                if(wordF[mi]<=query){
                    lo=mi+1;
                }else{
                    hi=mi;
                }
            }
            ans[i]=wordF.length-lo;
        }
        
        return ans;
    }
    
    private int F(String str){
        char current='z'+1;
        int freq=0;
        for(char ch:str.toCharArray()){
            if(ch<current){
                current=ch;
                freq=1;
            }else if(ch==current){
                freq+=1;
            }
        }
        
        return freq;
    }
}