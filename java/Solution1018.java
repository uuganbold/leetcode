import java.util.*;
class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans=new ArrayList<>(A.length);
        int mod=0;
        for(int a:A){
            mod=(mod<<1)|a;
            mod=mod%5;
            ans.add(mod==0);
        }
        
        return ans;
    }
}