import java.util.*;

class Solution1408 {

    /*
        T: O(N^2)
        S: O(N) for sorting
    */
    public List<String> stringMatching(String[] words) {
        List<String> ans=new ArrayList<>();
        
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[j].indexOf(words[i])>=0){
                   ans.add(words[i]);
                    break;
                } 
            }
        }
        
        return ans;
    }
}