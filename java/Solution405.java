class Solution405 {

    /*
        T: O(1)
        S: O(1)
    */
    public String toHex(int num) {
        char[] ans=new char[8];
        int lastNoneZero=0;
        for(int i=0;i<8;i++){
            int digit=num&15;
            if(digit<10){
                ans[8-i-1]=(char)(digit+'0');
            }else{
                ans[8-i-1]=(char)(digit-10+'a');
            }
            if(digit!=0){
                lastNoneZero=i;
            }
            num=num>>4;
        }
        
        return new String(ans,8-1-lastNoneZero,lastNoneZero+1);
    }
}