class Solution409 {

    /*
        T: O(N)
        S: O(1)
    */
    public int longestPalindrome(String s) {
        int[] counts=new int[52];
        for(char ch:s.toCharArray()){
            if(ch>='a') counts[ch-'a']++;
            else counts[ch-'A'+26]++;
        }
        
        boolean odd=false;
        int sum=0;
        for(int i=0;i<counts.length;i++){
            sum+=counts[i];
            if(counts[i]%2==1){
                sum-=1;
                odd=true;
            }
        }
        
        if(odd) sum+=1;
        
        return sum;
    }
}