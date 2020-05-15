class Solution806 {

    /*
        T: O(N)
        S: O(1)
    */
    public int[] numberOfLines(int[] widths, String S) {
        int line=1;
        int width=0;
        for(char ch:S.toCharArray()){
            int thisCharWidth=widths[ch-'a'];
            if(width+thisCharWidth>100){
                line++;
                width=thisCharWidth;
            }else{
                width+=thisCharWidth;
            }
        }
        
        return new int[]{line,width};
    }
}