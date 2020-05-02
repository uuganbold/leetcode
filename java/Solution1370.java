class Solution1370 {
    /*
    T : O(n)
    S : O(n)
    */
    public String sortString(String s) {
        int length=s.length();
        int[] charMap=new int[26];
        
        for(char ch:s.toCharArray()){
            charMap[ch-'a']++;
        }
        
        StringBuilder result=new StringBuilder();
        int direction=1;
        int i=0;
        while(result.length()<length){
            if(charMap[i]>0){
                result.append((char)('a'+i));
                charMap[i]--;
            }
            i+=direction;
            if(i>=26||i<0){
                direction*=-1;
                i+=direction;
            } 
        }
        return result.toString();
    }
}