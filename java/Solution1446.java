class Solution1446 {

    /*
        T: O(N)
        S: O(1)
    */
    public int maxPower(String s) {
        int length=0;
        
        int max=0;
        char latest=s.charAt(0);
        
        for(char ch:s.toCharArray()){
            if(ch==latest){
                length++;
            }else{
                if(length>max) max=length;
                latest=ch;
                length=1;
            }
        }
        
        if(length>max) max=length;
        
        return max;
    }
}