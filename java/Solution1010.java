class Solution1010 {

    /*
        T: O(N)
        S: O(1)
    */
    public int numPairsDivisibleBy60(int[] time) {
        int[] mods=new int[60];
        int count=0;
        
        for(int t:time){
            int mod=t%60;
            int pair=(60-mod)%60;
            
            count+=mods[pair];
            mods[mod]++;
        }
        
        return count;
    }
}