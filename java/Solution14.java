class Solution14 {

    /*
        T: O(N)
        S: O(1)
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int i=0;
        while(i<strs[0].length()){
            char charToCheck=strs[0].charAt(i);
            boolean allSame=true;
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i||strs[j].charAt(i)!=charToCheck){
                    allSame=false;
                    break;
                }
            }
            if(!allSame){
                break;
            }
            i++;
        }
        
        return strs[0].substring(0,i);
        
    }
}