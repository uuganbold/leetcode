import java.util.*;
class Solution1387 {
    
    Map<Integer,Integer> dp;

    /*
        T: O(NlogN)
        S: O(N)
    */
    public int getKth(int lo, int hi, int k) {
        
        dp=new HashMap<>();
            
        Pair[] powers=new Pair[hi-lo+1];
        for(int i=lo;i<=hi;i++){
            int p=power(i);
            powers[i-lo]=new Pair(i,p);
        }    
        Arrays.sort(powers);
        return powers[k-1].key;
    }
    
    private class Pair implements Comparable<Pair>{
        int key;
        int power;
        public Pair(int key, int power){
            this.key=key;
            this.power=power;
        }
        
        public int compareTo(Pair other){
            if(this.power==other.power){
                return this.key-other.key;
            }
            return this.power-other.power;
        }
    }
    
    private int power(int n){
        if(n==1){
            return 0;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        
        int ans=0;
        if(n%2==0){
            ans=1+power(n/2);
        }else{
            ans=1+power(3*n+1);
        }
        
        dp.put(n,ans);
        return ans;
        
    }
}