import java.util.*;
class Solution893 {

    /*
        T: O(N) N-length of all characters
        S: O(N) N- length of all characters
    */
    public int numSpecialEquivGroups(String[] A) {
        Set<String> distinctCounts=new HashSet<String>();
        
        for(String str:A){
            distinctCounts.add(sortStringKeepingParity(str));
        }
        
        return distinctCounts.size();
        
    }
    
    /*
        T: O(N) N-length of string
        S: O(N) N-length of string
    */
    private String sortStringKeepingParity(String str){
        int[][] freq=new int[2][26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            freq[i%2][ch-'a']++;
        }
        
        char[] result=new char[str.length()];
         
        for(int j=0;j<=1;j++){
            int pointer=0;
            for(int i=j;i<result.length;i+=2){
                while(freq[j][pointer]==0){
                    pointer++;
                }
                result[i]=(char)(pointer+'a');
                freq[j][pointer]--;
            }            
        }
              
        return new String(result);
    }
}