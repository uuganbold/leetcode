class Solution299 {

    /*
        T: O(N)
        S: O(1)
    */
    public String getHint(String secret, String guess) {
        int[] secretMap=new int[10];
        int[] guessMap=new int[10];
        
        int bulls=0;
        for(int i=0;i<secret.length();i++){
            int s=secret.charAt(i)-'0';
            int g=guess.charAt(i)-'0';
            secretMap[s]++;
            guessMap[g]++;
            
            if(s==g){
                bulls++;
            }
        }
        
        int cows=0;
        for(int i=0;i<10;i++){
            cows+=Math.min(secretMap[i],guessMap[i]);
        }
        
        return new StringBuilder().append(bulls).append("A").append(cows-bulls).append("B").toString();
    }
}