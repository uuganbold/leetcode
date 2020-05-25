class Solution1422 {

    /*
        T:O(N)
        S:O(1)
    */
    public int maxScore(String s) {
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') ones++;
        }
        
        int leftZeros=s.charAt(0)=='0'?1:0;
        int max=leftZeros+(ones-1+leftZeros);
        
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='0') leftZeros++;
            
            int leftOnes=(i+1)-leftZeros;
            
            int score=leftZeros+(ones-leftOnes);
            if(score>max) max=score;
        }
        
        return max;
    }
}